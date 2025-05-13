package com.example.Spring_project.service;

import com.example.Spring_project.dto.AuthRequest;
import com.example.Spring_project.dto.BalanceResponse;
import com.example.Spring_project.entity.User;
import com.example.Spring_project.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) { // Конструктор
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User registerUser(AuthRequest authRequest) { // Регистрация пользователя
        if (userRepository.existsByPhoneNumber(authRequest.getPhoneNumber())) { // Если пользователь уже сушествует
            throw new RuntimeException("Пользователь уже существует");
        }

        User user = new User();
        user.setPhoneNumber(authRequest.getPhoneNumber());
        user.setPassword(passwordEncoder.encode(authRequest.getPassword()));
        user.setBalance(BigDecimal.valueOf(1000.00)); // Начальный баланс 1000 руб

        return userRepository.save(user);
    }

    public BalanceResponse getBalance(User user) {
        BalanceResponse response = new BalanceResponse();
        response.setPhoneNumber(user.getPhoneNumber());
        response.setBalance(user.getBalance());
        return response;
    }
}
