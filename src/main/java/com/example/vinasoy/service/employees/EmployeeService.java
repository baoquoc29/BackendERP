package com.example.vinasoy.service.employees;

import com.example.vinasoy.dto.employee.RewardDisciplineDTO.RewardDisciplineResponseDTO;
import com.example.vinasoy.dto.employee.employeeDTO.EmployeeRequestDTO;
import com.example.vinasoy.dto.employee.employeeDTO.EmployeeResponseDTO;
import com.example.vinasoy.dto.income.EmployeesalaryDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface EmployeeService {
    public List<EmployeeResponseDTO> getAllInfoEmployee();
    EmployeeResponseDTO getEmployeeById(String id);
    public EmployeeResponseDTO updateEmployee(EmployeeRequestDTO updateDTO);
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeRequestDTO);
    public List<EmployeeResponseDTO> searchEmployees(String keywords);




}
