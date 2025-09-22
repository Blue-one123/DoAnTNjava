package com.example.nhatro.service.impl;

import com.example.nhatro.dto.UserDTO;
import com.example.nhatro.entity.User;
import com.example.nhatro.mapper.UserMapper;
import com.example.nhatro.repository.UserRepository;
import com.example.nhatro.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepo;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepo.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) {
        return userRepo.findById(id)
                .map(userMapper::toDto)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    /*@Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        // default password là username (chỉ demo), encode lại
        user.setPassword(passwordEncoder.encode(userDTO.getUsername()));
        User saved = userRepo.save(user);
        return userMapper.toDto(saved);
    }*/
    @Override
public UserDTO createUser(UserDTO userDTO) {
    // 1. Kiểm tra sự tồn tại của username hoặc email
    if (userRepo.existsByUsername(userDTO.getUsername()) || userRepo.existsByEmail(userDTO.getEmail())) {
        throw new RuntimeException("Username or Email already exists!");
    }
    
    User user = new User();
    user.setUsername(userDTO.getUsername());
    user.setEmail(userDTO.getEmail());
    
    // ✅ Sửa: Lấy mật khẩu từ userDTO và mã hóa nó
    user.setPassword(passwordEncoder.encode(userDTO.getPassword())); 
    
    // Lưu người dùng và trả về DTO
    User saved = userRepo.save(user);
    return userMapper.toDto(saved);
}

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        User updated = userRepo.save(user);
        return userMapper.toDto(updated);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepo.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepo.deleteById(id);
    }
}
