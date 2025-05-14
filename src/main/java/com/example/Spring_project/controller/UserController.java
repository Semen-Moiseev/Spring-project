package com.example.Spring_project.controller;

import com.example.Spring_project.dto.BalanceResponse;
import com.example.Spring_project.dto.UpdateUserRequest;
import com.example.Spring_project.entity.User;
import com.example.Spring_project.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping("/me")
    public ResponseEntity<User> updateCurrentUser(
            Authentication authentication,
            @RequestBody @Valid UpdateUserRequest request) {

        String phoneNumber = authentication.getName();
        User user = userService.findByPhoneNumber(phoneNumber);

        User updatedUser = userService.updateUser(user, request);
        return ResponseEntity.ok(updatedUser);
    }

    @GetMapping("/me")
    public ResponseEntity<User> getCurrentUser(
            Authentication authentication) {
        String phoneNumber = authentication.getName();
        User user = userService.findByPhoneNumber(phoneNumber);
        return ResponseEntity.ok(user);
    }
}
