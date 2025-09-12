package com.example.nhatro.mapper;

import com.example.nhatro.dto.UserDTO;
import com.example.nhatro.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = java.util.stream.Collectors.class)
public interface UserMapper {
    @Mapping(target = "roles", expression = "java(user.getRoles().stream().map(r -> r.getName()).collect(java.util.stream.Collectors.toSet()))")
    UserDTO toDto(User user);

    // mapping DTO->entity for register we will do manually in Service (because of password encode and roles)
}
