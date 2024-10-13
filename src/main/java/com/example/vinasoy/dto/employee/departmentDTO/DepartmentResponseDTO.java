package com.example.vinasoy.dto.employee.departmentDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentResponseDTO {
    private String departmentID;
    private String nameDepartment;
    private String addressDepartment;
    private String phoneDepartment;
}


