package com.example.Spring_project.service;

import com.example.Spring_project.dto.PaymentRequest;
import com.example.Spring_project.dto.PaymentResponse;
import com.example.Spring_project.entity.Transaction;
import com.example.Spring_project.entity.User;
import com.example.Spring_project.repository.TransactionRepository;
import com.example.Spring_project.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class PaymentService {
    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;

    public PaymentService(UserRepository userRepository, TransactionRepository transactionRepository) { // Конструктор
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public PaymentResponse processPayment(User sender, PaymentRequest request) { // Оплата
        PaymentResponse response = new PaymentResponse();

        if (sender.getBalance().compareTo(request.getAmount()) < 0) { // Недостаточно средств
            response.setSuccess(false);
            response.setMessage("Недостаточно средств на счете");
            return response;
        }

        sender.setBalance(sender.getBalance().subtract(request.getAmount())); // Списываем средства
        userRepository.save(sender);

        Transaction transaction = new Transaction(); // Сохраняем транзакцию
        transaction.setUser(sender);
        transaction.setRecipientPhone(request.getRecipientPhone());
        transaction.setAmount(request.getAmount());
        transactionRepository.save(transaction);

        response.setSuccess(true); // Формируем ответ
        response.setMessage("Оплата успешно выполнена");
        response.setAmount(request.getAmount());
        response.setRemainingBalance(sender.getBalance());
        response.setTimestamp(LocalDateTime.now());

        return response;
    }
}
