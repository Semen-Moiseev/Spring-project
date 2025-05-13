package com.example.Spring_project.controller;

import com.example.Spring_project.dto.BalanceResponse;
import com.example.Spring_project.entity.User;
import com.example.Spring_project.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    } // Конструктор

    @GetMapping("/balance")
    public BalanceResponse getBalance(@AuthenticationPrincipal User user) {
        return userService.getBalance(user);
    }
}
