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
@Table(name = "contract")
public class Contract {
    @Id
    @Size(max = 10)
    @Column(name = "ContractID", nullable = false, length = 10)
    private String contractID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SalaryGradeScaleID")
    private Salarygradescale salaryGradeScaleID;

    @Column(name = "SalaryContract", precision = 10, scale = 2)
    private BigDecimal salaryContract;

    @Column(name = "StartDate")
    private LocalDate startDate;

    @Column(name = "EndDate")
    private LocalDate endDate;

    @Size(max = 50)
    @Column(name = "ContractStatus", length = 50)
    private String contractStatus;

}