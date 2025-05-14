package com.example.Spring_project.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "recipientPhone", nullable = false)
    private String recipientPhone;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    public void setUser(User sender) {
        user = sender;
    }

    public void setAmount(BigDecimal amo) {
        amount = amo;
    }

    public void setRecipientPhone(String recipientPh) {
        recipientPhone = recipientPh;
    }
}
