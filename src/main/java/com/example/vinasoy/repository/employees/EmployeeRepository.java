package com.example.vinasoy.repository.employees;

import com.example.vinasoy.entity.employee.Contract;
import com.example.vinasoy.entity.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    @Query("SELECT e.contractID FROM Employee e WHERE e.employeeID = :employeeID")
    Contract findContractByEmployeeID(String employeeID);

    List<Employee> findByEmployeeNameContainingIgnoreCaseOrEmployeeIDContainingIgnoreCase(String employeeName, String employeeID); // Tìm kiếm theo tên hoặc mã nhân viên

}
