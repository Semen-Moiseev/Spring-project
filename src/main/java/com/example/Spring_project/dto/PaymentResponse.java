package com.example.Spring_project.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;

public class PaymentResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private boolean success;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String message;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal amount;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal remainingBalance;

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
}
