package com.example.vinasoy.entity.employee;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "employeesalary")
public class Employeesalary {
    @Id
    @Column(name = "EmployeeSalaryID", nullable = false, length = 10)
    private String employeeSalaryID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeID")
    private Employee employeeID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ContractID")
    private Contract contractID;

    @Column(name = "TotalAmount", precision = 18, scale = 2)
    private BigDecimal totalAmount;

    @Column(name = "CreatedDate")
    private LocalDate createdDate;

    @Column(name = "UpdatedDate")
    private LocalDate updatedDate;

    @Column(name = "Note", length = 1000)
    private String note;

}