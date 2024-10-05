package com.example.vinasoy.entity.employee;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "salarydebt")
public class Salarydebt {
    @Id
    @Size(max = 10)
    @Column(name = "SalaryDebtID", nullable = false, length = 10)
    private String salaryDebtID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeID")
    private Employee employeeID;

    @Size(max = 255)
    @Column(name = "DebtName")
    private String debtName;

    @Column(name = "TotalAmount", precision = 18, scale = 2)
    private BigDecimal totalAmount;

    @Column(name = "AmountPaid", precision = 18, scale = 2)
    private BigDecimal amountPaid;

    @Column(name = "AmountOwed", precision = 18, scale = 2)
    private BigDecimal amountOwed;

    @Column(name = "DueDate")
    private LocalDate dueDate;

    @Column(name = "CreateDate")
    private LocalDate createDate;

    @Column(name = "UpdateDate")
    private LocalDate updateDate;

    @Size(max = 50)
    @Column(name = "DebtStatus", length = 50)
    private String debtStatus;

    @Size(max = 1000)
    @Column(name = "Note", length = 1000)
    private String note;

}