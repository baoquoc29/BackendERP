package com.example.vinasoy.dto.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PositionsDTO {
    private String positionID;
    private String namePosition;
    private BigDecimal allowanceAmount;
}
