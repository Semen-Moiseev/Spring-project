package com.example.Spring_project.repository;

import com.example.Spring_project.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    Page<Transaction> findByUserId(int userId, Pageable pageable); //Найти пользователя по id
}
