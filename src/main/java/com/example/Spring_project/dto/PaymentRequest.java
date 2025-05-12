package com.example.Spring_project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class PaymentRequest {
    @NotBlank(message = "Требуется указать номер телефона")
    private String phoneNumber;

    @NotNull(message = "Требуемая сумма")
    @Positive(message = "Сумма должна быть положительной")
    private int amount;

    public int getAmount() {
        return amount;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
