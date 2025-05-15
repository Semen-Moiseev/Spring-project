package com.example.Spring_project.service;

import com.example.Spring_project.dto.TransactionResponse;
import com.example.Spring_project.entity.Transaction;
import com.example.Spring_project.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {
    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private TransactionService transactionService;

    @Test
    void getUserTransactions_shouldReturnPaginatedResults() {
        // Подготовка данных
        int userId = 1;
        Pageable pageable = PageRequest.of(0, 10, Sort.by("timestamp").descending());

        Transaction transaction = new Transaction();
        transaction.setId(1);
        transaction.setRecipientPhone("79098765432");
        transaction.setAmount(new BigDecimal("100.50"));
        transaction.setTimestamp(LocalDateTime.now());

        Page<Transaction> mockPage = new PageImpl<>(List.of(transaction), pageable, 1);

        // Имитация сохранения пользователя в БД, возвращает транзакцию
        when(transactionRepository.findByUserId(userId, pageable)).thenReturn(mockPage);

        // Выполнение тестируемого действия
        Page<TransactionResponse> result = transactionService.getUserTransactions(userId, pageable);

        // Проверка
        assertNotNull(result);
        assertEquals(1, result.getTotalElements());
        assertEquals("79098765432", result.getContent().get(0).getRecipientPhone());

        // Проверка, что метод findByUserId был вызван 1 раз
        verify(transactionRepository, times(1)).findByUserId(userId, pageable);
    }
}
