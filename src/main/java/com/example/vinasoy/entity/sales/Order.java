package com.example.vinasoy.entity.sales;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "OrderID", nullable = false, length = 10)
    private String orderID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerID")
    private Customer customerID;

    @Column(name = "OrderDate")
    private LocalDate orderDate;

    @Lob
    @Column(name = "ShippingAddress")
    private String shippingAddress;

    @Lob
    @Column(name = "Notes")
    private String notes;

    @Column(name = "OrderStatus", length = 50)
    private String orderStatus;

}