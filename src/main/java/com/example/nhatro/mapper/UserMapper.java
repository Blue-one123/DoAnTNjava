package com.example.nhatro.mapper;

import com.example.nhatro.dto.UserDTO;
import com.example.nhatro.entity.User;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserDTO toDto(User user) {
        if (user == null) return null;

        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setRoles(
            user.getRoles().stream()
                .map(r -> r.getName())
                .collect(Collectors.toSet())
        );

        return dto;
    }
}
