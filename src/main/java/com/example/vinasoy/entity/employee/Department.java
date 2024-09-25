package com.example.vinasoy.entity.employee;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "department")
public class Department {
    @Id
    @Column(name = "DepartmentID", nullable = false, length = 10)
    private String departmentID;
    @NotNull(message = "Department name cannot be null")
    @Column(name = "NameDepartment")
    private String nameDepartment;

    public Department(String departmentID, String nameDepartment) {
        this.departmentID = departmentID;
        this.nameDepartment = nameDepartment;
    }

}