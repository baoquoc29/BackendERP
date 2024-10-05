package com.example.vinasoy.entity.employee;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "department")
public class Department {
    @Id
    @Size(max = 10)
    @Column(name = "DepartmentID", nullable = false, length = 10)
    private String departmentID;

    @Size(max = 255)
    @Column(name = "NameDepartment")
    private String nameDepartment;

    @Size(max = 255)
    @Column(name = "AddressDepartment")
    private String addressDepartment;

    @Size(max = 15)
    @Column(name = "PhoneDepartment", length = 15)
    private String phoneDepartment;

}