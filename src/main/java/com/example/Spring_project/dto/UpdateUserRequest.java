package com.example.Spring_project.dto;

import com.example.Spring_project.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class UpdateUserRequest {
    @NotBlank(message = "Требуется ввести полное имя")
    @Size(max = 100, message = "ФИО не должно превышать 100 символов")
    private String fullName;

    @NotBlank(message = "Требуется ввести адрес электронной почты")
    @Email(message = "Некорректный email")
    private String email;

    private User.Gender gender;

    @Past(message = "Дата рождения должна быть в прошлом")
    private LocalDate birthDate;

    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public User.Gender getGender() { return gender; }
    public LocalDate getBirthDate() { return birthDate; }
}
