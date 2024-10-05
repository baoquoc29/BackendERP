package com.example.vinasoy.dto.employee;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class PositionsDTO {
    private String positionId;
    private String namePosition;
    private BigDecimal allowanceAmount;
}
