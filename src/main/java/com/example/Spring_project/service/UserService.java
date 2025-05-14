package com.example.Spring_project.service;

import com.example.Spring_project.dto.AuthRequest;
import com.example.Spring_project.dto.BalanceResponse;
import com.example.Spring_project.dto.UpdateUserRequest;
import com.example.Spring_project.entity.User;
import com.example.Spring_project.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
        if (userRepository.existsByPhoneNumber(authRequest.getPhoneNumber())) {
            throw new RuntimeException("Пользователь с таким номером телефона уже существует");
        }

        if (userRepository.existsByEmail(authRequest.getEmail())) {
            throw new RuntimeException("Пользователь с таким адресом электронной почты уже существует");
        }

        User user = new User();
        user.setPhoneNumber(authRequest.getPhoneNumber());
        user.setPassword(passwordEncoder.encode(authRequest.getPassword()));
        user.setBalance(BigDecimal.valueOf(1000.00)); // Начальный баланс 1000 руб

        user.setFullName(authRequest.getFullName());
        user.setEmail(authRequest.getEmail());
        user.setGender(authRequest.getGender());
        user.setBirthDate(authRequest.getBirthDate());

        return userRepository.save(user);
    }

    @Transactional
    public User updateUser(User user, UpdateUserRequest request) {
        if (request.getEmail() != null && userRepository.existsByEmailAndIdNot(request.getEmail(), user.getId())) {
            throw new RuntimeException("Данный email Уже используется другим пользователем");
        }

        // Обновляем только те поля, которые пришли в запросе
        if (request.getFullName() != null) {
            user.setFullName(request.getFullName());
        }

        if (request.getEmail() != null) {
            user.setEmail(request.getEmail());
        }

        if (request.getGender() != null) {
            user.setGender(request.getGender());
        }

        if (request.getBirthDate() != null) {
            user.setBirthDate(request.getBirthDate());
        }

        return userRepository.save(user);
    }

    public BalanceResponse getBalance(User user) { // Получение баланса
        BalanceResponse response = new BalanceResponse();
        response.setPhoneNumber(user.getPhoneNumber());
        response.setBalance(user.getBalance());
        return response;
    }

    public User findByPhoneNumber(String phoneNumber) {
        User user = userRepository.findByPhoneNumber(phoneNumber).orElseThrow(()
                -> new UsernameNotFoundException("Пользователь не найден"));

        return user;
    }
}
