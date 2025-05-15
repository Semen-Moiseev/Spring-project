package com.example.Spring_project.entity;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    @Test
    void userCreation_shouldSetBasicFields() {
        System.out.println("Создание пользователя (userCreation_shouldSetBasicFields)\n");
        // Подготовка данных
        User user = new User();
        user.setPhoneNumber("79123456789");
        user.setPassword("123");
        user.setFullName("Имя");
        user.setEmail("mail@mail.ru");
        user.setGender(User.Gender.MAN);
        user.setBirthDate(LocalDate.ofEpochDay(2004-03-13));
        user.setBalance(new BigDecimal("1000.00"));

        // Выполнение тестируемого действия
        System.out.println("Номер телефона: " + user.getPhoneNumber());
        System.out.println("Пароль: " + user.getPassword());
        System.out.println("Имя: " + user.getFullName());
        System.out.println("Почта: " + user.getEmail());
        System.out.println("Пол: " + user.getGender());
        System.out.println("Дата рождения: " + user.getBirthDate());
        System.out.println("Баланс: " + user.getBalance());

        // Проверка
        assertEquals("79123456789", user.getPhoneNumber());
        assertEquals("123", user.getPassword());
        assertEquals("Имя", user.getFullName());
        assertEquals("mail@mail.ru", user.getEmail());
        assertEquals(User.Gender.MAN, user.getGender());
        assertEquals(LocalDate.ofEpochDay(2004-03-13), user.getBirthDate());
        assertEquals(0, new BigDecimal("1000.00").compareTo(user.getBalance()));

        System.out.println("------------------------------\n");
    }

    @Test
    void userUpdate_shouldChangeFields() {
        System.out.println("Обновление пользователя (userUpdate_shouldChangeFields)\n");
        // Подготовка данных
        User user = new User();
        user.setFullName("Старое имя");
        System.out.println("Старое имя: " + user.getFullName());
        user.setEmail("old@mail.ru");
        System.out.println("Старая почта: " + user.getEmail());

        // Выполнение тестируемого действия
        user.setFullName("Новое имя");
        System.out.println("Новое имя: " + user.getFullName());
        user.setEmail("new@mail.ru");
        System.out.println("Новая почта: " + user.getEmail());

        // Проверка
        assertEquals("Новое имя", user.getFullName());
        assertEquals("new@mail.ru", user.getEmail());

        System.out.println("------------------------------\n");
    }
}
