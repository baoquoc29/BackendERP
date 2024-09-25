package com.example.vinasoy.entity.warehouse;

import com.example.vinasoy.entity.employee.Employee;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "goodsissuenote")
public class Goodsissuenote {
    @Id
    @Column(name = "GoodsIssueNoteID", nullable = false, length = 10)
    private String goodsIssueNoteID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeID")
    private Employee employeeID;

    @Column(name = "DateOfIssue")
    private LocalDate dateOfIssue;

    @Column(name = "Note")
    private String note;

}