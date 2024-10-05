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
@Table(name = "employeesalary")
public class Employeesalary {
    @Id
    @Size(max = 10)
    @Column(name = "EmployeeSalaryID", nullable = false, length = 10)
    private String employeeSalaryID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeID")
    private Employee employeeID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ContractID")
    private Contract contractID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PositionID")
    private Position positionID;

    @Column(name = "SalaryContract", precision = 18, scale = 2)
    private BigDecimal salaryContract;

    @Column(name = "Bonus", precision = 18, scale = 2)
    private BigDecimal bonus;

    @Column(name = "Forfeit", precision = 18, scale = 2)
    private BigDecimal forfeit;

    @Column(name = "Allowance", precision = 18, scale = 2)
    private BigDecimal allowance;

    @Column(name = "Insurance", precision = 18, scale = 2)
    private BigDecimal insurance;

    @Column(name = "PersonalIncomeTax", precision = 18, scale = 2)
    private BigDecimal personalIncomeTax;

    @Column(name = "TotalAmount", precision = 18, scale = 2)
    private BigDecimal totalAmount;

    @Column(name = "CreatedDate")
    private LocalDate createdDate;

    @Column(name = "UpdatedDate")
    private LocalDate updatedDate;

    @Size(max = 1000)
    @Column(name = "Note", length = 1000)
    private String note;

}