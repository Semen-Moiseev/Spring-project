package com.example.Spring_project.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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

    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp = LocalDateTime.now();

    public void setUser(User sender) { user = sender; }
    public void setAmount(BigDecimal quantity) { amount = quantity; }
    public void setRecipientPhone(String phone) { recipientPhone = phone; }
    public void setTimestamp(LocalDateTime newTimestamp) { timestamp = newTimestamp; }
}
