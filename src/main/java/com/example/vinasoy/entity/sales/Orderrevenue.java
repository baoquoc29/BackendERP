package com.example.vinasoy.entity.sales;

import com.example.vinasoy.entity.employee.Employee;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "orderrevenue")
public class Orderrevenue {
    @Id
    @Column(name = "OrderRevenueID", nullable = false, length = 10)
    private String orderRevenueID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeID")
    private Employee employeeID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OrderID")
    private Order orderID;

    @Column(name = "TotalAmount", precision = 18, scale = 2)
    private BigDecimal totalAmount;

    @Column(name = "CreateDate")
    private LocalDate createDate;

    @Column(name = "UpdateDate")
    private LocalDate updateDate;

    @Column(name = "Note", length = 1000)
    private String note;

}