package com.example.vinasoy.dto.employee;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class EmployeesalaryDTO {
    private String employeeSalaryId;
    private String employeeId;
    private String contractId;
    private String positionId;
    private String timeKeepingDetailId;
    private BigDecimal totalAmount;
    private LocalDate createdDate;
    private LocalDate updatedDate;
    private String note;


}
