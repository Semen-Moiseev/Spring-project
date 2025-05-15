package com.example.Spring_project.entity;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TransactionTest {
    @Test
    void transactionCreation_shouldSetAllFields() {
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
        Transaction transaction = new Transaction();
        transaction.setId(1);
        transaction.setUser(user);
        transaction.setRecipientPhone("79098765432");
        transaction.setAmount(new BigDecimal("100.50"));
        transaction.setTimestamp(LocalDateTime.now());

        // Проверка
        assertEquals(1, transaction.getId());
        assertEquals("79123456789", transaction.getUser().getPhoneNumber());
        assertEquals("79098765432", transaction.getRecipientPhone());
        assertEquals(0, new BigDecimal("100.50").compareTo(transaction.getAmount()));
        assertNotNull(transaction.getTimestamp());
    }
}
