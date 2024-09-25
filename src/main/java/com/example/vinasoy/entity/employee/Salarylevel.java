package com.example.vinasoy.entity.employee;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "salarylevel")
public class Salarylevel {
    @Id
    @Column(name = "SalaryLevelID", nullable = false, length = 10)
    private String salaryLevelID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GradeID")
    private Salarygrade gradeID;

    @Column(name = "SalaryLevelAmount", precision = 10, scale = 2)
    private BigDecimal salaryLevelAmount;

    @Column(name = "NOTE", length = 500)
    private String note;

}