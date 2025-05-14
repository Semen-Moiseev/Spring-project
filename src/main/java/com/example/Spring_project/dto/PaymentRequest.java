package com.example.Spring_project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class PaymentRequest {
    @NotBlank(message = "Требуется указать номер телефона")
    private String recipientPhone;

    @NotNull(message = "Требуется указать сумму перевода")
    @Positive(message = "Сумма должна быть положительной")
    private BigDecimal amount;


    public BigDecimal getAmount() {
        return amount;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }
}
