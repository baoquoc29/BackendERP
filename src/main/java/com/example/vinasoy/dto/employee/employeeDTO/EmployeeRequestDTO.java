package com.example.vinasoy.dto.employee.employeeDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequestDTO {

    private String employeeID;

    private String employeeName;

    private LocalDate birthday;

    private String gender;

    private String phoneNumber;

    private String email;

    private String cccd;
    private String contractID;

    private String address;

    private String employeeStatus;
    private String positionID;
    private String departmentID;
}
