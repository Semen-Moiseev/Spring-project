package com.example.Spring_project.controller;

import com.example.Spring_project.dto.PaymentRequest;
import com.example.Spring_project.dto.PaymentResponse;
import com.example.Spring_project.entity.User;
import com.example.Spring_project.service.PaymentService;
import com.example.Spring_project.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    private final PaymentService paymentService;
    private final UserService userService;

    public PaymentController(PaymentService paymentService, UserService userService) { // Конструктор
        this.paymentService = paymentService;
        this.userService = userService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)  //POST-запрос, возврат данных ы формате JSON (Оплата)
    public ResponseEntity<PaymentResponse> makePayment(
            Authentication authentication,
            @RequestBody @Valid PaymentRequest request) {

        String phoneNumber = authentication.getName();
        User user = userService.findByPhoneNumber(phoneNumber);

        PaymentResponse response = paymentService.processPayment(user, request);
        return ResponseEntity.ok(response);
    }
}
