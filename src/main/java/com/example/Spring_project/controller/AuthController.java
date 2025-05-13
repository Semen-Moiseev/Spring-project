package com.example.Spring_project.controller;

import com.example.Spring_project.dto.AuthRequest;
import com.example.Spring_project.entity.User;
import com.example.Spring_project.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    } // Конструктор

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody AuthRequest authRequest) {
        return ResponseEntity.ok(userService.registerUser(authRequest));
    }
}
