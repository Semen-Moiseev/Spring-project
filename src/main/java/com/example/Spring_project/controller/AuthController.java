package com.example.Spring_project.controller;

import com.example.Spring_project.dto.AuthRequest;
import com.example.Spring_project.entity.User;
import com.example.Spring_project.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth") //Базовый URL для всех методов контроллера
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) { this.userService = userService; } // Конструктор

    @PostMapping("/register") //POST-запрос с указанием URL (Регистрация пользователя)
    public ResponseEntity<User> register(@RequestBody @Valid AuthRequest authRequest) { //Преобразует тело HTTP-запроса (JSON/XML) в Java-объект / Активирует валидацию
        return ResponseEntity.ok(userService.registerUser(authRequest));
    }
}
