package com.example.Spring_project.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class BalanceResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING) // Формат данных
    private String phoneNumber;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal balance;
}
