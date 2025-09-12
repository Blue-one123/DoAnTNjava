package com.example.nhatro.mapper;

import com.example.nhatro.dto.UserDTO;
import com.example.nhatro.entity.User;
import java.util.stream.Collectors;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-12T10:24:54+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );
        userDTO.setUsername( user.getUsername() );
        userDTO.setEmail( user.getEmail() );

        userDTO.setRoles( user.getRoles().stream().map(r -> r.getName()).collect(java.util.stream.Collectors.toSet()) );

        return userDTO;
    }
}
