package com.example.Spring_project.dto;

import jakarta.validation.constraints.NotBlank;

public class AuthRequest {
    @NotBlank(message = "Требуется указать номер телефона")
    private String phoneNumber;

    @NotBlank(message = "Требуется ввести пароль")
    private String password;

    public String getPhoneNumber() { return phoneNumber; }
    public String getPassword() {
        return password;
    }
}
