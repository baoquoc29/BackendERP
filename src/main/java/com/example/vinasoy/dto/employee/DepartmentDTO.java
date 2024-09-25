package com.example.vinasoy.dto.employee;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DepartmentDTO {
    private String departmentId;
    private String nameDepartment;
}
