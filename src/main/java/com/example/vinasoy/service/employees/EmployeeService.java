package com.example.vinasoy.service.employees;

import com.example.vinasoy.dto.employee.employeeDTO.EmployeeRequestDTO;
import com.example.vinasoy.dto.employee.employeeDTO.EmployeeResponseDTO;

import java.util.List;

public interface EmployeeService {
    public List<EmployeeResponseDTO> getAllInfoEmployee();
    EmployeeResponseDTO getEmployeeById(String id);
    public EmployeeResponseDTO updateEmployee(EmployeeRequestDTO updateDTO);
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeRequestDTO);
    public List<EmployeeResponseDTO> searchEmployees(String keywords);


}
