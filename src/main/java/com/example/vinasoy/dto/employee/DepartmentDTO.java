package com.example.vinasoy.dto.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
    private String departmentID;
    private String nameDepartment;
    private String addressDepartment;
    private String phoneDepartment;
}
