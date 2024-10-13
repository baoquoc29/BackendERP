package com.example.vinasoy.entity.sales;

import com.example.vinasoy.entity.employee.Employee;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @OneToMany(
            mappedBy = "invoice",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )

    @JsonManagedReference
    private Set<Invoicedetails> invoicedetails = new HashSet<>();


    public void addInvoice(Invoicedetails invoicedetail) {
        if(invoicedetail != null) {
            invoicedetails.add(invoicedetail);
            invoicedetail.setInvoice(this);
        }
    }

    public void removeInvoicce(Invoicedetails invoicedetail) {
        if(order != null) {
            invoicedetails.remove(invoicedetail);
            invoicedetail.setInvoice(null);
        }
    }


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
