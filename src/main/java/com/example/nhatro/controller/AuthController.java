package com.example.nhatro.controller;

import com.example.nhatro.dto.*;
import com.example.nhatro.entity.KhachHang;
import com.example.nhatro.entity.Role;
import com.example.nhatro.entity.User;
import com.example.nhatro.repository.RoleRepository;
import com.example.nhatro.repository.UserRepository;
import com.example.nhatro.security.JwtUtil;
import com.example.nhatro.mapper.UserMapper;
import com.example.nhatro.repository.KhachHangRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authManager;
    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final UserMapper userMapper;
     private final KhachHangRepository khachHangRepository;
    // ✅ API đăng ký (register user thường)
    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@Valid @RequestBody UserRegisterRequest req) {
    if (userRepo.findByUsername(req.getUsername()).isPresent()) {
        throw new RuntimeException("Username đã tồn tại");
    }

    // Tạo khach_hang rỗng với email
    KhachHang kh = new KhachHang();
    kh.setEmail(req.getEmail()); // ban đầu chỉ có email
    KhachHang savedKh = khachHangRepository.save(kh);

    // Tạo user
    User u = new User();
    u.setUsername(req.getUsername());
    u.setPassword(passwordEncoder.encode(req.getPassword()));
    u.setEmail(req.getEmail());
    u.setKhachHang(savedKh);

    // role mặc định = USER
    Role r = roleRepo.findByName("ROLE_USER")
            .orElseThrow(() -> new RuntimeException("Role not found"));
    u.setRoles(Set.of(r));

    User saved = userRepo.save(u);

    return ResponseEntity.ok(userMapper.toDto(saved));
}

    // ✅ API đăng nhập
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest req) {
    Authentication auth = authManager.authenticate(
            new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword())
    );

    SecurityContextHolder.getContext().setAuthentication(auth);

    org.springframework.security.core.userdetails.User principal =
            (org.springframework.security.core.userdetails.User) auth.getPrincipal();

    var roles = principal.getAuthorities()
            .stream()
            .map(a -> a.getAuthority())
            .collect(Collectors.toSet());

    // lấy user trong DB
    User user = userRepo.findByUsername(principal.getUsername())
            .orElseThrow(() -> new RuntimeException("User not found"));

    // lấy id khách hàng (nếu có liên kết)
    Long khachHangId = null;
    if (user.getKhachHang() != null) {
        khachHangId = user.getKhachHang().getId();
    }

    // tạo JWT
    String token = jwtUtil.generateToken(principal.getUsername(), roles);

    AuthResponse resp = new AuthResponse();
    resp.setToken(token);
    resp.setUsername(principal.getUsername());
    resp.setRoles(roles);
    resp.setKhachHangId(khachHangId);

    return ResponseEntity.ok(resp);
}
}
