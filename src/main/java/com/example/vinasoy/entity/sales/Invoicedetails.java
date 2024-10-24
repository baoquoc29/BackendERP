package com.example.vinasoy.entity.sales;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "invoicedetails")
public class Invoicedetails {
    @Id
    @Column(name = "InvoiceDetailID")
    private String invoiceDetailId;

    @Column(name = "InvoiceID")
    private String invoiceId;

    @Column(name = "ProductID")
    private String productId;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "ProductPrice")
    private BigDecimal productPrice;

    @Column(name = "TotalInvoice")
    private BigDecimal totalInvoice;

    @Column(name = "InvoiceStatus")
    private String invoiceStatus;
}
