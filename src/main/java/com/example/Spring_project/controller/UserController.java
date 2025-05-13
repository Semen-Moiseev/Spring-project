package com.example.Spring_project.controller;

import com.example.Spring_project.dto.BalanceResponse;
import com.example.Spring_project.entity.User;
import com.example.Spring_project.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) { this.userService = userService; } // Конструктор

    @GetMapping(value = "/balance", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BalanceResponse> getBalance(Authentication authentication) {
        String phoneNumber = authentication.getName();
        User user = userService.findByPhoneNumber(phoneNumber);
        return ResponseEntity.ok(userService.getBalance(user));
    }
}
