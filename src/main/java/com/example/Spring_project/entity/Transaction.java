package com.example.Spring_project.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity //Сущность
@Table(name = "transactions") // Имя таблицы БД
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id генерируется базой данных
    private int id;

    @ManyToOne //Связь много к одному
    @JoinColumn(name = "user_id", nullable = false) //Объединенная колонка с названием, не null
    private User user;

    @Column(name = "recipientPhone", nullable = false) //Колонка с названием, не null
    private String recipientPhone;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp = LocalDateTime.now();

    public int getId() { return id; }
    public void setId(int i) { id = i; }
    public User getUser() { return user; }
    public void setUser(User sender) { user = sender; }
    public String getRecipientPhone() { return recipientPhone; }
    public void setRecipientPhone(String phone) { recipientPhone = phone; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal quantity) { amount = quantity; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime newTimestamp) { timestamp = newTimestamp; }
}
