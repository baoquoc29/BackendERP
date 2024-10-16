package com.example.vinasoy.dto.warehouse;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class MaterialdebtDTO {
    private String materialDebtId;
    private String employeeId;
    private String materialCostId;
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
