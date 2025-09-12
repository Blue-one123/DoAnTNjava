package com.example.nhatro.config;

import com.example.nhatro.entity.Role;
import com.example.nhatro.entity.User;
import com.example.nhatro.repository.RoleRepository;
import com.example.nhatro.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    private final RoleRepository roleRepo = null;
    private final UserRepository userRepo = null;
    private final PasswordEncoder passwordEncoder = null;

    @Bean
    CommandLineRunner init() {
        return args -> {
            roleRepo.findByName("ROLE_ADMIN").orElseGet(() -> roleRepo.save(new Role(null, "ROLE_ADMIN")));
            roleRepo.findByName("ROLE_USER").orElseGet(() -> roleRepo.save(new Role(null, "ROLE_USER")));

            if (userRepo.findByUsername("admin").isEmpty()) {
                Role adminRole = roleRepo.findByName("ROLE_ADMIN").get();
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin123"));
                admin.setEmail("admin@example.com");
                admin.setEnabled(true);
                admin.setRoles(Set.of(adminRole));
                userRepo.save(admin);
            }
        };
    }
}
