package com.example.nhatro.dto;

import lombok.Data;
import java.util.Set;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String email;
     private String password; // ✅ Thêm dòng này
    private Set<String> roles;
}
