package com.example.Spring_project.service;

import com.example.Spring_project.dto.TransactionDto;
import com.example.Spring_project.entity.Transaction;
import com.example.Spring_project.repository.TransactionRepository;
import com.example.Spring_project.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) { // Конструктор
        this.transactionRepository = transactionRepository;
    }

    public Page<TransactionDto> getUserTransactions(int userId, Pageable pageable) {
        Page<Transaction> transactions = transactionRepository.findByUserId(userId, pageable);
        return transactions.map(this::convertToDto);
    }

    private TransactionDto convertToDto(Transaction transaction) {
        return new TransactionDto(
                transaction.getId(),
                transaction.getRecipientPhone(),
                transaction.getAmount(),
                transaction.getTimestamp()
        );
    }
}
