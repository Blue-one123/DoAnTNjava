package com.example.nhatro.controller;

import com.example.nhatro.dto.*;
import com.example.nhatro.entity.Role;
import com.example.nhatro.entity.User;
import com.example.nhatro.repository.RoleRepository;
import com.example.nhatro.repository.UserRepository;
import com.example.nhatro.security.JwtUtil;
import com.example.nhatro.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;


import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.Authentication;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authManager = null;
    private final UserRepository userRepo = null;
    private final RoleRepository roleRepo = null;
    private final PasswordEncoder passwordEncoder = null;
    private final JwtUtil jwtUtil = null;
    private final UserMapper userMapper = null;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@Valid @RequestBody UserRegisterRequest req) {
        if (userRepo.findByUsername(req.getUsername()).isPresent()) {
            throw new RuntimeException("Username đã tồn tại");
        }
        User u = new User();
        u.setUsername(req.getUsername());
        u.setPassword(passwordEncoder.encode(req.getPassword()));
        u.setEmail(req.getEmail());
        Role r = roleRepo.findByName("ROLE_USER").orElseThrow(() -> new RuntimeException("Role not found"));
        u.setRoles(Set.of(r));
        User saved = userRepo.save(u);
        return ResponseEntity.ok(userMapper.toDto(saved));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest req) {
        Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) auth.getPrincipal();
        var roles = principal.getAuthorities().stream().map(a -> a.getAuthority()).collect(Collectors.toSet());
        String token = jwtUtil.generateToken(principal.getUsername(), roles);
        AuthResponse resp = new AuthResponse();
        resp.setToken(token);
        resp.setUsername(principal.getUsername());
        return ResponseEntity.ok(resp);
    }
}
