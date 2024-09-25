package com.example.vinasoy.service.employees;

import com.example.vinasoy.dto.employee.DepartmentDTO;
import com.example.vinasoy.entity.employee.Department;

import java.util.List;

public interface DepartmentService {

    public void createDepartment(String positionName);


    public void deleteDepartment(String positionId);


    public void updateDepartment(String positionId, String newPositionName);

    public List<DepartmentDTO> getAllDepartments();
    public DepartmentDTO getDepartmentsById(String positionId);

}
