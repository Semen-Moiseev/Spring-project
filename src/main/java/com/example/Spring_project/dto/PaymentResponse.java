package com.example.Spring_project.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING) // Формат данных
    private boolean success;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String message;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal amount;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal remainingBalance;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime timestamp;

    public void setSuccess(boolean bool) {
        success = bool;
    }
    public void setMessage(String text) {
        message = text;
    }
    public void setAmount(BigDecimal quantity) {
        amount = quantity;
    }
    public void setRemainingBalance(BigDecimal balance) {
        remainingBalance = balance;
    }
    public void setTimestamp(LocalDateTime newTimestamp) {
        timestamp = newTimestamp;
    }
}
