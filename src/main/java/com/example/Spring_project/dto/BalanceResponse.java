package com.example.Spring_project.dto;

public class BalanceResponse {
    private String phoneNumber;
    private int balance;

    public void setPhoneNumber(String newNumberPhone) {
        phoneNumber = newNumberPhone;
    }

    public void setBalance(int newBalance) {
        balance = newBalance;
    }
}
