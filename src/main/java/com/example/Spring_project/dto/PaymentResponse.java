package com.example.Spring_project.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class PaymentResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private boolean success;
    @JsonProperty("message")
    private String message;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal amount;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal remainingBalance;

    public void setSuccess(boolean b) {
        success = b;
    }

    public void setMessage(String mess) {
        message = mess;
    }

    public void setAmount(BigDecimal amo) {
        amount = amo;
    }

    public void setRemainingBalance(BigDecimal balance) {
        remainingBalance = balance;
    }
}
