package com.example.vinasoy.dto.employee;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class AccountsreceivableDTO {
    private String accountsReceivableId;
    private String employeeId;
    private String revenueId;
    private String debtName;
    private BigDecimal actualRevenue;
    private BigDecimal amountPaid;
    private BigDecimal amountOwed;
    private LocalDate dueDate;
    private LocalDate createDate;
    private LocalDate updateDate;
    private String debtStatus;
    private String note;

}
