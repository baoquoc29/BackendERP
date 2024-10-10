package com.example.vinasoy.dto.employee.contractDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ContractDetailResponseDTO {
    private String contractID;
    private String employeeName;
    private String departmentName;
    private String positionName;
    private BigDecimal salaryContract;
    private LocalDate startDate;
    private LocalDate endDate;
    private String contractStatus;
}
