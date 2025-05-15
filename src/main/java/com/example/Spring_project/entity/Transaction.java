package com.example.Spring_project.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
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
}
