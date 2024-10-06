package com.example.vinasoy.entity.sales;

import com.example.vinasoy.entity.employee.Employee;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.*;
import org.aspectj.weaver.ast.Or;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @Column(name = "InvoiceID")
    private String invoiceId;

    @Column(name = "TotalAmount")
    private BigDecimal totalAmount;

    @Column(name = "PaymentDate")
    private LocalDate paymentDate;

    @Column(name = "PaymentMethod")
    private String paymentMethod;

    // Quan hệ OneToOne với bảng Order
    @OneToOne
    @JoinColumn(name = "OrderID", referencedColumnName = "OrderID")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeID", nullable = false, referencedColumnName = "EmployeeID")
    @JsonBackReference
    private Employee employee;


    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId='" + invoiceId + '\'' +
                ", totalAmount=" + totalAmount +
                ", paymentDate=" + paymentDate +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
