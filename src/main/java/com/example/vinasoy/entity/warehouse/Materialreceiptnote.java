package com.example.vinasoy.entity.warehouse;

import com.example.vinasoy.entity.employee.Employee;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "materialreceiptnote")
public class Materialreceiptnote {
    @Id
    @Column(name = "MaterialReceiptNoteID", nullable = false, length = 10)
    private String materialReceiptNoteID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SupplierID")
    private Supplier supplierID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeID")
    private Employee employeeID;

    @Column(name = "DateOfEntry")
    private LocalDate dateOfEntry;

    @Column(name = "Note")
    private String note;

}