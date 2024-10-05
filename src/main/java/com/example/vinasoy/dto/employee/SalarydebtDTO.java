package com.example.vinasoy.dto.employee;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class SalarydebtDTO {
    private String salaryDebtId;
    private String employeeId;
    private String employeeSalaryId;
    private String debtName;
    private BigDecimal totalAmount;
    private BigDecimal amountPaid;
    private BigDecimal amountOwed;
    private LocalDate dueDate;
    private LocalDate createDate;
    private LocalDate updateDate;
    private String debtStatus;
    private String note;


}
