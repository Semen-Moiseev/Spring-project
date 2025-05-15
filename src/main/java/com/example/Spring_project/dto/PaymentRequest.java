package com.example.Spring_project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentRequest {
    @NotBlank(message = "Требуется указать номер телефона") // Проверка на пустую строку
    @Size(max = 11, message = "Номер телефона слишком длинный") // Проверка на размер строки
    private String recipientPhone;

    @NotNull(message = "Требуется указать сумму перевода") // Проверка на пустую строку
    @Positive(message = "Сумма должна быть положительной") // Проверка положительно ли число
    private BigDecimal amount;

    private LocalDateTime timestamp;

    public BigDecimal getAmount() {
        return amount;
    }
    public String getRecipientPhone() {
        return recipientPhone;
    }
    public LocalDateTime getTimestamp() { return timestamp; }
}
