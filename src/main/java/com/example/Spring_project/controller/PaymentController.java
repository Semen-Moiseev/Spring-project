package com.example.Spring_project.controller;

import com.example.Spring_project.dto.PaymentRequest;
import com.example.Spring_project.dto.PaymentResponse;
import com.example.Spring_project.entity.User;
import com.example.Spring_project.repository.UserRepository;
import com.example.Spring_project.service.PaymentService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public PaymentResponse makePayment(
            @AuthenticationPrincipal User user,
            @RequestBody PaymentRequest paymentRequest) {
        return paymentService.processPayment(user, paymentRequest);
    }
}
