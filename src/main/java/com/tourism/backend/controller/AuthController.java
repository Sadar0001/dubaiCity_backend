package com.tourism.backend.controller;

import com.tourism.backend.model.User;
import com.tourism.backend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*") // Allow frontend to call this
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public String signUp(@RequestBody User user) {
        return authService.signUp(user);
    }

    @PostMapping("/signin")
    public Object signIn(@RequestBody User loginRequest) {
        return authService.signIn(loginRequest.getEmail(), loginRequest.getPassword());
    }
}