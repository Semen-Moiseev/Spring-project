package com.example.Spring_project.dto;

import com.example.Spring_project.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.time.LocalDate;

@Data
public class AuthRequest {
    @NotBlank(message = "Требуется указать номер телефона") // Проверка на пустую строку
    @Size(max = 11, message = "Номер телефона слишком длинный") // Проверка на размер строки
    private String phoneNumber;

    @NotBlank(message = "Требуется ввести пароль")
    private String password;

    @NotBlank(message = "Требуется ввести полное имя")
    @Size(max = 100, message = "ФИО не должно превышать 100 символов")
    private String fullName;

    @NotBlank(message = "Требуется ввести адрес электронной почты")
    @Email(message = "Некорректный email") // Проверка формата почты
    private String email;

    private User.Gender gender;

    @Past(message = "Дата рождения должна быть в прошлом") // Проверка даты на отношение к прошлому
    private LocalDate birthDate;
}
