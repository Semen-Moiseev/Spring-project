package com.example.Spring_project.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TransactionResponse {
    public TransactionResponse(int id, String recipientPhone, BigDecimal amount, LocalDateTime timestamp) { // Конструктор
        this.id = id;
        this.recipientPhone = recipientPhone;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING) // Формат данных
    private int id;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String recipientPhone;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal amount;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime timestamp;
}
