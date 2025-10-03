package com.example.nhatro.dto;

import lombok.Data;

import java.util.Set;

@Data
public class AuthResponse {
    private String username;
    private String token;
    private Set<String> roles; // thêm roles nếu muốn frontend check quyền
    private Long khachHangId;
}
