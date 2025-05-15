package com.example.Spring_project.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionDto {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private int id;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String recipientPhone;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal amount;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime timestamp;

    public TransactionDto(int id, String recipientPhone, BigDecimal amount, LocalDateTime timestamp) {
        this.id = id;
        this.recipientPhone = recipientPhone;
        this.amount = amount;
        this.timestamp = timestamp;
    }
}
