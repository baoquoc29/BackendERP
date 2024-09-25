package com.example.vinasoy.repository.employees;
import com.example.vinasoy.entity.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,String> {
}
