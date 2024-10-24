package com.example.vinasoy.service.income;

import com.example.vinasoy.dto.income.EmployeesalaryDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeSalaryService {
    List<EmployeesalaryDTO> getEmployeeSalary(Integer year,Integer month,String position);
    List<String> getNamePosition();
}
