package com.example.vinasoy.dto.employee;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class ContractDTO {
    private String contractId;
    private String salaryGradeScaleId;
    private BigDecimal salaryContract;
    private LocalDate startDate;
    private LocalDate endDate;
    private String contractStatus;

}
