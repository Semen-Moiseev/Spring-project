package com.example.Spring_project.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "phoneNumber", nullable = false, unique = true)
    private String phoneNumber; // Логин - номер телефона

    @Column(name = "password", nullable = false)
    private String password; // Хэш пароля

    @Column(name = "balance", nullable = false)
    private BigDecimal balance = BigDecimal.valueOf(1000.00); // Начальный баланс 1000.00 руб

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String newNumberPhone) { phoneNumber = newNumberPhone; }
    public String getPassword() { return password; }
    public void setPassword(String newPassword) { password = newPassword; }
    public BigDecimal getBalance() { return balance; }
    public void setBalance(BigDecimal newBalance) { balance = newBalance; }
}
