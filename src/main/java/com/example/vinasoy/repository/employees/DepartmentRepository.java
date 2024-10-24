package com.example.vinasoy.repository.employees;

import com.example.vinasoy.entity.employee.Department;
import com.example.vinasoy.entity.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, String> {
    List<Department> findByDepartmentIDContainingOrNameDepartmentContaining(String departmentID, String nameDepartment);
}
