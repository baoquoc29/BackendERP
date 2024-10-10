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
@Table(name = "goodsreceipt")
public class Goodsreceipt {
    @Id
    @Column(name = "GoodsReceiptID")
    private String goodsReceiptId;

    @Column(name = "QuantityImported")
    private Integer quantityImported;

    @Column(name = "ImportPrice")
    private BigDecimal importPrice;

    @Column(name = "ImportDate")
    private LocalDate importDate;

    @Column(name = "Note")
    private String note;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeID", nullable = false, referencedColumnName = "EmployeeID")
    @JsonBackReference
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductID", nullable = false, referencedColumnName = "ProductID")
    @JsonBackReference
    private Product product;

    @Override
    public String toString() {
        return "Goodsreceipt{" +
                "goodsReceiptId='" + goodsReceiptId + '\'' +
                ", quantityImported=" + quantityImported +
                ", importPrice=" + importPrice +
                ", importDate=" + importDate +
                ", note='" + note + '\'' +
                '}';
    }
}
