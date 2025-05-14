package com.example.Spring_project.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

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

    @Column(name = "fullName", nullable = false)
    private String fullName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "birthDate", nullable = false)
    private LocalDate birthDate;

    public enum Gender { MAN, WOMAN }

    public int getId() { return id; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String newNumberPhone) { phoneNumber = newNumberPhone; }
    public String getPassword() { return password; }
    public void setPassword(String newPassword) { password = newPassword; }
    public BigDecimal getBalance() { return balance; }
    public void setBalance(BigDecimal newBalance) { balance = newBalance; }
    public String getFullName() { return fullName; }
    public void setFullName(String newFullName) { fullName = newFullName; }
    public String getEmail() { return email; }
    public void setEmail(String newEmail) { email = newEmail; }
    public Gender getGender() { return gender; }
    public void setGender(Gender newGender) { gender = newGender; }
    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate newBirthDate) { birthDate = newBirthDate; }
}
