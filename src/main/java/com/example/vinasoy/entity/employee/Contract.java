package com.example.vinasoy.entity.employee;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "contract")
public class Contract {
    @Id
    @Column(name = "ContractID", nullable = false, length = 10)
    private String contractID;

    @Column(name = "SalaryContract", precision = 10, scale = 2)
    private BigDecimal salaryContract;

    @Column(name = "StartDate")
    private LocalDate startDate;

    @Column(name = "EndDate")
    private LocalDate endDate;

    @Column(name = "ContractStatus", length = 50)
    private String contractStatus;

}