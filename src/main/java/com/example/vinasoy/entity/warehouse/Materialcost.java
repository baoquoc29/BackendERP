package com.example.vinasoy.entity.warehouse;

import com.example.vinasoy.entity.employee.Employee;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "materialcost")
public class Materialcost {
    @Id
    @Size(max = 10)
    @Column(name = "MaterialCostID", nullable = false, length = 10)
    private String materialCostID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeID")
    private Employee employeeID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaterialReceiptNoteID")
    private Materialreceiptnote materialReceiptNoteID;

    @Size(max = 255)
    @Column(name = "CostName")
    private String costName;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "CostUnit", precision = 18, scale = 2)
    private BigDecimal costUnit;

    @Column(name = "VAT", precision = 18, scale = 2)
    private BigDecimal vat;

    @Column(name = "TotalAmount", precision = 18, scale = 2)
    private BigDecimal totalAmount;

    @Column(name = "CreatedDate")
    private LocalDate createdDate;

    @Column(name = "UpdatedDate")
    private LocalDate updatedDate;

    @Size(max = 1000)
    @Column(name = "Note", length = 1000)
    private String note;

}