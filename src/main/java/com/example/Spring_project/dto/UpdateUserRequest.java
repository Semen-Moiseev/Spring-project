package com.example.Spring_project.dto;

import com.example.Spring_project.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.time.LocalDate;

@Data
public class UpdateUserRequest {
    @NotBlank(message = "Требуется ввести полное имя") // Проверка на пустую строку
    @Size(max = 100, message = "ФИО не должно превышать 100 символов") // Проверка на размер строки
    private String fullName;

    @NotBlank(message = "Требуется ввести адрес электронной почты")
    @Email(message = "Некорректный email") // Проверка формата почты
    private String email;

    private User.Gender gender;

    @Past(message = "Дата рождения должна быть в прошлом") // Проверка даты на отношение к прошлому
    private LocalDate birthDate;
}
