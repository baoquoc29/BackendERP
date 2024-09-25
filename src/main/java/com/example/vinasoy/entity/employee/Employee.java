package com.example.vinasoy.entity.employee;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "EmployeeID", nullable = false, length = 10)
    private String employeeID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DepartmentID")
    private Department departmentID;

    @Column(name = "EmployeeName")
    private String employeeName;

    @Column(name = "Birthday")
    private LocalDate birthday;

    @Column(name = "PhoneNumber", length = 20)
    private String phoneNumber;

    @Column(name = "Email")
    private String email;

    @Column(name = "CCCD", length = 12)
    private String cccd;

    @Column(name = "Address")
    private String address;

    @Column(name = "EmployeeStatus", length = 50)
    private String employeeStatus;

}