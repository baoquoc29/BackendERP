package com.example.vinasoy.dto.employee.employeeDTO;

import com.example.vinasoy.dto.employee.PositionDTO.PositionResponseDTO;
import com.example.vinasoy.dto.employee.departmentDTO.DepartmentResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponseDTO {
    private String employeeID;
    private String employeeName;
    private LocalDate birthday;
    private String gender;
    private String phoneNumber;
    private String email;
    private String cccd;
    private String address;
    private String employeeStatus;
    private PositionResponseDTO position;
    private DepartmentResponseDTO department;
}
