package com.example.vinasoy.entity.sales;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @Column(name = "PaymentID", nullable = false, length = 10)
    private String paymentID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OrderID")
    private Order orderID;

    @Column(name = "PaymentAmount", precision = 10, scale = 2)
    private BigDecimal paymentAmount;

    @Column(name = "PaymentDate")
    private LocalDate paymentDate;

    @Column(name = "PaymentMethod", length = 50)
    private String paymentMethod;

}