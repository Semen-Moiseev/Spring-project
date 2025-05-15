package com.example.Spring_project.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "phoneNumber", nullable = false, unique = true) //Колонка с названием, не null
    private String phoneNumber; // Логин - номер телефона

    @Column(name = "password", nullable = false)
    private String password; // Хэш пароля

    @Column(name = "balance", nullable = false)
    private BigDecimal balance = BigDecimal.valueOf(1000.00); // Начальный баланс 1000.00 руб

    @Column(name = "fullName", nullable = false)
    private String fullName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING) // Значение перечисления сохраняется в БД как строка
    private Gender gender;

    @Column(name = "birthDate", nullable = false)
    private LocalDate birthDate;

    public enum Gender { MAN, WOMAN }
}
