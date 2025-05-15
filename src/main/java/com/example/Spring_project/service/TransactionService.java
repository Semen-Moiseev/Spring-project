package com.example.Spring_project.service;

import com.example.Spring_project.dto.TransactionResponse;
import com.example.Spring_project.entity.Transaction;
import com.example.Spring_project.repository.TransactionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) { // Конструктор
        this.transactionRepository = transactionRepository;
    }

    public Page<TransactionResponse> getUserTransactions(int userId, Pageable pageable) {
        Page<Transaction> transactions = transactionRepository.findByUserId(userId, pageable);
        return transactions.map(this::convertToDto);
    }

    private TransactionResponse convertToDto(Transaction transaction) {
        return new TransactionResponse(
                transaction.getId(),
                transaction.getRecipientPhone(),
                transaction.getAmount(),
                transaction.getTimestamp()
        );
    }
}
