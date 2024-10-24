package com.example.vinasoy.entity.warehouse;

import com.example.vinasoy.entity.employee.Employee;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "materialissuenote")
public class Materialissuenote {
    @Id
    @Size(max = 10)
    @Column(name = "MaterialIssueNoteID", nullable = false, length = 10)
    private String materialIssueNoteID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeID")
    private Employee employeeID;

    @Column(name = "DateOfIssue")
    private LocalDate dateOfIssue;

    @Size(max = 255)
    @Column(name = "Note")
    private String note;

}