package com.example.Spring_project.service;

import com.example.Spring_project.dto.PaymentRequest;
import com.example.Spring_project.dto.PaymentResponse;
import com.example.Spring_project.entity.Transaction;
import com.example.Spring_project.entity.User;
import com.example.Spring_project.repository.TransactionRepository;
import com.example.Spring_project.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;

    public PaymentService(UserRepository userRepository, TransactionRepository transactionRepository) { // Конструктор
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public PaymentResponse processPayment(User sender, PaymentRequest request) {
        PaymentResponse response = new PaymentResponse();

        // Проверяем достаточно ли средств
        if (sender.getBalance().compareTo(request.getAmount()) < 0) {
            response.setSuccess(false);
            response.setMessage("Недостаточно средств на счете");
            return response;
        }

        // Списываем средства
        sender.setBalance(sender.getBalance().subtract(request.getAmount()));
        userRepository.save(sender);

        // Сохраняем транзакцию
        Transaction transaction = new Transaction();
        transaction.setUser(sender);
        transaction.setRecipientPhone(request.getRecipientPhone());
        transaction.setAmount(request.getAmount());
        transactionRepository.save(transaction);

        // Формируем ответ
        response.setSuccess(true);
        response.setMessage("Оплата успешно выполнена");
        response.setAmount(request.getAmount());
        response.setRemainingBalance(sender.getBalance());

        return response;
    }
}
