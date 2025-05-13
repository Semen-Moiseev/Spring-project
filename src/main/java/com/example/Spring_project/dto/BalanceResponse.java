package com.example.Spring_project.dto;

import java.math.BigDecimal;

public class BalanceResponse {
    private String phoneNumber;
    private BigDecimal balance;

    public void setPhoneNumber(String newNumberPhone) {
        phoneNumber = newNumberPhone;
    }
    public void setBalance(BigDecimal newBalance) {
        balance = newBalance;
    }
}
