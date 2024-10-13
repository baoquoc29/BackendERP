package com.example.vinasoy.entity.sales;

import com.example.vinasoy.entity.employee.Employee;
import com.example.vinasoy.entity.manufacture.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "goodsissue")
public class Goodsissue {
    @Id
    @Column(name = "GoodsIssueID")
    private String goodsIssueId;

    @Column(name = "QuantityExported")
    private Integer quantityExported;

    @Column(name = "ExportPrice")
    private BigDecimal exportPrice;

    @Column(name = "ExportDate")
    private LocalDate exportDate;

    @Column(name = "Note")
    private String note;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeID", nullable = false, referencedColumnName = "EmployeeID")
    @JsonBackReference
    private Employee employee;

    @OneToOne
    @JoinColumn(name = "InvoiceID", referencedColumnName = "InvoiceID")
    private Invoice invoice;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductID", nullable = false, referencedColumnName = "ProductID")
    @JsonBackReference
    private Product product;


    @Override
    public String toString() {
        return "Goodsissue{" +
                "goodsIssueId='" + goodsIssueId + '\'' +
                ", quantityExported=" + quantityExported +
                ", exportPrice=" + exportPrice +
                ", exportDate=" + exportDate +
                ", note='" + note + '\'' +
                '}';
    }
}
