package com.example.vinasoy.repository.employees;

import com.example.vinasoy.dto.income.EmployeesalaryDTO;
import com.example.vinasoy.entity.employee.Contract;
import com.example.vinasoy.entity.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    @Query("SELECT e.contractID FROM Employee e WHERE e.employeeID = :employeeID")
    Contract findContractByEmployeeID(String employeeID);

    List<Employee> findByEmployeeNameContainingIgnoreCaseOrEmployeeIDContainingIgnoreCase(String employeeName, String employeeID); // Tìm kiếm theo tên hoặc mã nhân viên
    @Query("SELECT new com.example.vinasoy.dto.income.EmployeesalaryDTO(" +
            "emp.employeeID, emp.employeeName,positionID.namePosition, emp.phoneNumber, emp.email, emp.cccd, contractID.salaryContract," +
            "CAST((contractID.salaryContract + (scl.salaryAmount * ad.numberOfWorkingDays) + positionID.allowanceAmount) AS java.math.BigDecimal) , " +
            "ad.workMonth, ad.workYear, emp.employeeStatus,ad.numberOfWorkingDays,ad.numberOfDaysOff,ad.numberOfDaysLate) " +
            "FROM Employee emp " +
            "LEFT JOIN emp.positionID positionID " +
            "LEFT JOIN emp.contractID contractID " +
            "LEFT JOIN Attendancerecord ad ON emp.employeeID = ad.employeeID.employeeID " +
            "LEFT JOIN Salarygradescale scl ON contractID.salaryGradeScaleID.salaryGradeScaleID = scl.salaryGradeScaleID " +
            "WHERE (:monthChoice IS NULL OR ad.workMonth = :monthChoice) " +
            "AND (:yearChoice IS NULL OR ad.workYear = :yearChoice) AND (:position IS NULL OR positionID.namePosition =: position)")
    List<EmployeesalaryDTO> listSalary(@Param("yearChoice") Integer yearChoice,
                                       @Param("monthChoice") Integer monthChoice,@Param("position") String position);




}
