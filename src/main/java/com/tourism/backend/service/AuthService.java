package com.tourism.backend.service;

import com.tourism.backend.model.User;
import com.tourism.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public String signUp(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            return "Email already exists";
        }
        userRepository.save(user);
        return "User registered successfully";
    }

    public Object signIn(String email, String password) {
        Optional<User> userOpt = userRepository.findByEmail(email);

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            // Simple plain text check (No Security)
            if (user.getPassword().equals(password)) {
                return user; // Return full user object if valid
            }
        }
        return "Invalid Credentials";
    }
}