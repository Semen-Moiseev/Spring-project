package com.example.Spring_project.controller;

import com.example.Spring_project.dto.TransactionResponse;
import com.example.Spring_project.entity.User;
import com.example.Spring_project.service.TransactionService;
import com.example.Spring_project.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionService transactionService;
    private final UserService userService;

    public TransactionController(TransactionService transactionService, UserService userService) { // Конструктор
        this.transactionService = transactionService;
        this.userService = userService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE) //GET-запрос, возврат данных ы формате JSON (Вывод список транзакций)
    public ResponseEntity<Page<TransactionResponse>> getTransactions(
            Authentication authentication,
            @RequestParam(defaultValue = "0") int page, //Параметры для пагинации и их базовые значения
            @RequestParam(defaultValue = "10") int size) {
        String phoneNumber = authentication.getName();
        User user = userService.findByPhoneNumber(phoneNumber);

        Pageable pageable = PageRequest.of(page, size, Sort.by("timestamp").descending());
        Page<TransactionResponse> transactions = transactionService.getUserTransactions(user.getId(), pageable);

        return ResponseEntity.ok(transactions);
    }
}
