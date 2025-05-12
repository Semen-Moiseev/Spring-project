package com.example.Spring_project.service;

import com.example.Spring_project.dto.PaymentRequest;
import com.example.Spring_project.dto.PaymentResponse;
import com.example.Spring_project.entity.Transaction;
import com.example.Spring_project.entity.User;
import com.example.Spring_project.repository.TransactionRepository;
import com.example.Spring_project.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final UserRepository userRepository;
    private TransactionRepository transactionRepository;

    public PaymentService(UserRepository userRepository, TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public PaymentResponse processPayment(User user, PaymentRequest paymentRequest) {
        PaymentResponse response = new PaymentResponse();

        if (user.getBalance() > paymentRequest.getAmount()) {
            response.setSuccess(false);
            response.setMessage("Недостаточно средств");
            return response;
        }

        // Списание средств
        user.setBalance(user.getBalance() - paymentRequest.getAmount());
        userRepository.save(user);

        // Создание транзакции
        Transaction transaction = new Transaction();
        transaction.setUser(user);
        transaction.setDateTime(LocalDateTime.now());
        transaction.setPhoneNumber(paymentRequest.getPhoneNumber());
        transaction.setAmount(paymentRequest.getAmount());
        transactionRepository.save(transaction);

        response.setSuccess(true);
        response.setMessage("Платеж прошел успешно");
        response.setDateTime(transaction.getDateTime());
        response.setAmount(paymentRequest.getAmount());
        response.setRemainingBalance(user.getBalance());

        return response;
    }
}
