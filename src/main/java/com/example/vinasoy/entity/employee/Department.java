package com.example.vinasoy.entity.employee;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "department")
public class Department {
    @Id
    @Column(name = "DepartmentID", nullable = false, length = 10)
    private String departmentID;

    @Column(name = "NameDepartment")
    private String nameDepartment;

}