package com.example.vinasoy.repository.employees;

import com.example.vinasoy.entity.employee.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, String> {
}
