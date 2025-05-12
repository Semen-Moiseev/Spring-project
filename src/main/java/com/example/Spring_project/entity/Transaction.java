package com.example.Spring_project.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "dateTime", nullable = false)
    private LocalDateTime dateTime;

    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber; // Номер телефона, на который совершается оплата

    @Column(name = "amount", nullable = false)
    private int amount;

    public void setUser(User newUser) {
        user = newUser;
    }

    public void setDateTime(LocalDateTime now) {
        dateTime = now;
    }

    public void setPhoneNumber(String newPhoneNumber) {
        phoneNumber = newPhoneNumber;
    }

    public void setAmount(int newAmount) {
        amount = newAmount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
