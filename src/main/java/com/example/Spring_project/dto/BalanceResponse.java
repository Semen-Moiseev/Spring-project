package com.example.Spring_project.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;

public class BalanceResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING) // Формат данных
    private String phoneNumber;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal balance;

    public void setPhoneNumber(String newNumberPhone) {
        phoneNumber = newNumberPhone;
    }
    public void setBalance(BigDecimal newBalance) {
        balance = newBalance;
    }
}
