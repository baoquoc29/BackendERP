package com.example.vinasoy.service.income.impl;

import com.example.vinasoy.dto.income.EmployeesalaryDTO;
import com.example.vinasoy.repository.employees.EmployeeRepository;
import com.example.vinasoy.repository.employees.PositionsRepository;
import com.example.vinasoy.service.income.EmployeeSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeSalaryServiceImpl implements EmployeeSalaryService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    PositionsRepository positionsRepository;
    @Override
    public List<EmployeesalaryDTO> getEmployeeSalary(Integer month,Integer year,String position) {
        return employeeRepository.listSalary(month,year,position);
    }

    @Override
    public List<String> getNamePosition() {
        return positionsRepository.findAllnamePosition();
    }
}
