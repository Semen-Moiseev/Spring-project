package com.example.Spring_project.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.List;

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
    private int balance = 1000; // Начальный баланс 1000 руб

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String newNumberPhone) {
        phoneNumber = newNumberPhone;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String newPassword) {
        password = newPassword;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int newBalance) {
        balance = newBalance;
    }
}
