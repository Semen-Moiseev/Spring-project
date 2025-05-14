package com.example.Spring_project.dto;

import com.example.Spring_project.entity.User;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class AuthRequest {
    @NotBlank(message = "Требуется указать номер телефона")
    private String phoneNumber;

    @NotBlank(message = "Требуется ввести пароль")
    private String password;

    @NotBlank(message = "Требуется ввести полное имя")
    private String fullName;

    @NotBlank(message = "Требуется ввести адрес электронной почты")
    private String email;

    @NotBlank(message = "Требуется ввести пол")
    private User.Gender gender;

    @NotBlank(message = "Требуется ввести дату рождения")
    private LocalDate birthDate;

    public String getPhoneNumber() { return phoneNumber; }
    public String getPassword() {
        return password;
    }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public User.Gender getGender() { return gender; }
    public LocalDate getBirthDate() { return birthDate; }
}
