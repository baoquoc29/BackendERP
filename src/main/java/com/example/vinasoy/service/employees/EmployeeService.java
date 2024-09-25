package com.example.vinasoy.service.employees;

import com.example.vinasoy.dto.employee.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    public EmployeeDTO getEmployeeById(String employeeId);
    public List<EmployeeDTO> getAllEmployees();
}
