package com.example.vinasoy.entity.employee;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Size(max = 10)
    @Column(name = "EmployeeID", nullable = false, length = 10)
    private String employeeID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PositionID")
    private Position positionID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DepartmentID")
    private Department departmentID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ContractID")
    private Contract contractID;

    @Size(max = 255)
    @Column(name = "EmployeeName")
    private String employeeName;

    @Column(name = "Birthday")
    private LocalDate birthday;

    @Size(max = 10)
    @Column(name = "Gender", length = 10)
    private String gender;

    @Size(max = 15)
    @Column(name = "PhoneNumber", length = 15)
    private String phoneNumber;

    @Size(max = 255)
    @Column(name = "Email")
    private String email;

    @Size(max = 12)
    @Column(name = "CCCD", length = 12)
    private String cccd;

    @Size(max = 255)
    @Column(name = "Address")
    private String address;

    @Size(max = 50)
    @Column(name = "EmployeeStatus", length = 50)
    private String employeeStatus;

}