package com.example.nhatro.dto;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserRegisterRequest {
    @NotBlank private String username;
    @NotBlank @Size(min = 6) private String password;
    @Email private String email;
}
