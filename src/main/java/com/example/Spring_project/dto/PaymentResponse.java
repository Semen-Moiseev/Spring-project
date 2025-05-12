package com.example.Spring_project.dto;

import java.time.LocalDateTime;

public class PaymentResponse {
    private boolean success;
    private String message;
    private LocalDateTime dateTime;
    private int amount;
    private int remainingBalance;

    public void setSuccess(boolean newSuccess) {
        success = newSuccess;
    }

    public void setMessage(String newMessage) {
        message = newMessage;
    }

    public void setDateTime(LocalDateTime now) {
        dateTime = now;
    }

    public void setAmount(int newAmount) {
        amount = newAmount;
    }

    public void setRemainingBalance(int newRemainingBalance) {
        remainingBalance = newRemainingBalance;
    }
}
