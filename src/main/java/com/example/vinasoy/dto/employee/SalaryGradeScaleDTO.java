package com.example.vinasoy.dto.employee;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class SalaryGradeScaleDTO {
    private String salaryGradeScaleId;
    private String salaryScale;
    private String salaryGradeName;
    private BigDecimal salaryAmount;
    private String status;
}
