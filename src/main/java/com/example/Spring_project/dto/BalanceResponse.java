package com.example.Spring_project.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class BalanceResponse {
    @JsonProperty("phone_number")
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
