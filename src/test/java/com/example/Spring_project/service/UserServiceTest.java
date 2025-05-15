package com.example.Spring_project.service;

import com.example.Spring_project.entity.User;
import com.example.Spring_project.repository.UserRepository;
import com.example.Spring_project.dto.UpdateUserRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void updateUser_shouldUpdateExistingUser() {
        System.out.println("Обновление существующего пользователя (updateUser_shouldUpdateExistingUser)\n");
        // Подготовка данных
        int userId = 1;
        User existingUser = new User();
        existingUser.setId(userId);
        System.out.println("id пользователя: " + existingUser.getId());
        existingUser.setFullName("Старое имя");
        System.out.println("Старое имя пользователя: " + existingUser.getFullName());

        UpdateUserRequest request = new UpdateUserRequest();
        request.setFullName("Новое имя");
        System.out.println("\nНовое имя из запроса: " + request.getFullName());

        // Имитация сохранения пользователя в БД, возвращает пользователя
        when(userRepository.save(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Выполнение тестируемого действия
        User updatedUser = userService.updateUser(existingUser, request);
        System.out.println("\nНовое имя пользователя: " + updatedUser.getFullName());

        // Проверка
        assertEquals("Новое имя", updatedUser.getFullName());
        // Проверка, что метод save был вызван 1 раз
        verify(userRepository, times(1)).save(existingUser);
    }
}
