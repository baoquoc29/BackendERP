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
@Table(name = "revenue")
public class Revenue {
    @Id
    @Size(max = 10)
    @Column(name = "RevenueID", nullable = false, length = 10)
    private String revenueID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeID")
    private Employee employeeID;

    @Size(max = 255)
    @Column(name = "RevenueName")
    private String revenueName;

    @Column(name = "VAT")
    private Integer vat;

    @Column(name = "GrossRevenue", precision = 18, scale = 2)
    private BigDecimal grossRevenue;

    @Column(name = "ActualRevenue", precision = 18, scale = 2)
    private BigDecimal actualRevenue;

    @Column(name = "CreateDate")
    private LocalDate createDate;

    @Column(name = "UpdateDate")
    private LocalDate updateDate;

    @Size(max = 1000)
    @Column(name = "Note", length = 1000)
    private String note;

}