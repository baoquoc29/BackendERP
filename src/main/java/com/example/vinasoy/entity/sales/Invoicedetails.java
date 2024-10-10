package com.example.vinasoy.entity.sales;

import com.example.vinasoy.entity.employee.Employee;
import com.example.vinasoy.entity.manufacture.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "invoicedetails")
public class Invoicedetails {
    @Id
    @Column(name = "InvoiceDetailID")
    private String invoiceDetailId;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "ProductPrice")
    private BigDecimal productPrice;

    @Column(name = "TotalInvoice")
    private BigDecimal totalInvoice;

    @Column(name = "InvoiceStatus")
    private String invoiceStatus;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "InvoiceID", nullable = false, referencedColumnName = "InvoiceID")
    @JsonBackReference
    private Invoice invoice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductID", nullable = false, referencedColumnName = "ProductID")
    @JsonBackReference
    private Product product;

    @Override
    public String toString() {
        return "Invoicedetails{" +
                "invoiceDetailId='" + invoiceDetailId + '\'' +
                ", quantity=" + quantity +
                ", productPrice=" + productPrice +
                ", totalInvoice=" + totalInvoice +
                ", invoiceStatus='" + invoiceStatus + '\'' +
                '}';
    }
}
