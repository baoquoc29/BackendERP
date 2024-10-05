package com.example.vinasoy.entity.employee;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "salarygradescale")
public class Salarygradescale {
    @Id
    @Size(max = 10)
    @Column(name = "SalaryGradeScaleID", nullable = false, length = 10)
    private String salaryGradeScaleID;

    @Size(max = 255)
    @Column(name = "SalaryScale")
    private String salaryScale;

    @Size(max = 255)
    @Column(name = "SalaryGradeName")
    private String salaryGradeName;

    @Column(name = "SalaryAmount", precision = 10, scale = 2)
    private BigDecimal salaryAmount;

    @Size(max = 50)
    @Column(name = "Status", length = 50)
    private String status;

}