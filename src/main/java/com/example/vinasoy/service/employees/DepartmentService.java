package com.example.vinasoy.service.employees;

import com.example.vinasoy.dto.employee.DepartmentDTO;
import com.example.vinasoy.dto.employee.departmentDTO.DepartmentResponseDTO;

import java.util.List;

public interface DepartmentService {
    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO);
    public List<DepartmentDTO> getAllDepartments();
    public DepartmentDTO getDepartmentById(String id);
    public DepartmentDTO updateDepartment(DepartmentDTO departmentDTO);
    public void deleteDepartment(String id);
    public List<DepartmentResponseDTO> searchDepartments(String searchKeywords);

}
