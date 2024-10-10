package com.example.vinasoy.dto.employee.contractDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractResponseDTO {
    private String contractID;
    private String salaryGradeScaleID;
    private BigDecimal salaryContract;
    private LocalDate startDate;
    private LocalDate endDate;
    private String contractStatus;
}
