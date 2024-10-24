package com.example.vinasoy.dto.income;

import com.example.vinasoy.dto.employee.EmployeeDTO;
import com.example.vinasoy.dto.employee.PositionsDTO;
import com.example.vinasoy.dto.employee.employeeDTO.EmployeeResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@NoArgsConstructor
@Data
@AllArgsConstructor
    public class EmployeesalaryDTO {
    private String employeeID;
    private String employeeName;
    private String namePosition;
    private String phoneNumber;
    private String email;
    private String cccd;
    private BigDecimal salaryContract;
    private BigDecimal  totalSalary;
    private Integer workMonth;
    private Integer workYear;
    private String employeeStatus;
    private Integer numberOfWorkingDays;
    private Integer numberOfDaysOff;
    private Integer numberOfDaysLate;

}


