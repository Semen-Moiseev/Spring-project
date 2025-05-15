package com.example.Spring_project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PaymentRequest {
    @NotBlank(message = "Требуется указать номер телефона") // Проверка на пустую строку
    @Size(max = 11, message = "Номер телефона слишком длинный") // Проверка на размер строки
    private String recipientPhone;

    @NotNull(message = "Требуется указать сумму перевода")
    @Positive(message = "Сумма должна быть положительной") // Проверка положительно ли число
    private BigDecimal amount;

    private LocalDateTime timestamp;
}
