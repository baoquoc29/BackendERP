package com.example.vinasoy.dto.employee.contractDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ContractRequestDTO {

    @NotNull(message = "Contract ID is required")
    @Size(max = 10, message = "Contract ID must be at most 10 characters")
    private String contractID;

    @NotNull(message = "Salary Grade Scale ID is required")
    private String salaryGradeScaleID;

    @NotNull(message = "Salary Contract is required")
    private BigDecimal salaryContract;

    @NotNull(message = "Start Date is required")
    private LocalDate startDate;

    @NotNull(message = "End Date is required")
    private LocalDate endDate;

    @Size(max = 50, message = "Contract Status must be at most 50 characters")
    private String contractStatus;
}
