package com.example.vinasoy.dto.employee;

import lombok.Data;

import java.time.LocalDate;
@Data
public class EmployeeDTO {
    private String employeeId;
    private String positionId;
    private String departmentId;
    private String contractId;
    private String employeeName;
    private LocalDate birthday;
    private String gender;
    private String phoneNumber;
    private String email;
    private String cccd;
    private String address;
    private String employeeStatus;

}
