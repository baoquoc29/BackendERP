package com.example.vinasoy.controller.income;

import com.example.vinasoy.dto.income.EmployeesalaryDTO;
import com.example.vinasoy.dto.sales.ApiResponse;

import com.example.vinasoy.service.income.EmployeeSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/salaries")
public class SalaryEmployeeController {
    @Autowired
    EmployeeSalaryService employeeService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<EmployeesalaryDTO>>> getSalaryEmployees(@RequestParam(required = false) Integer month,@RequestParam(required = false) Integer year,@RequestParam(required = false) String position) {
        ApiResponse<List<EmployeesalaryDTO>> apiResponse = new ApiResponse<>();
        List<EmployeesalaryDTO> list = employeeService.getEmployeeSalary(year,month,position);
        apiResponse.setCode(200);
        apiResponse.setData(list);
        apiResponse.setMessage("List all salary employees");
        return ResponseEntity.ok(apiResponse);
    }
    @GetMapping("/positions")
    public ResponseEntity<ApiResponse<List<String>>> getAllNamePosition() {
        ApiResponse<List<String>> apiResponse = new ApiResponse<>();
        List<String> list = employeeService.getNamePosition();
        apiResponse.setCode(200);
        apiResponse.setData(list);
        apiResponse.setMessage("List all name position");
        return ResponseEntity.ok(apiResponse);
    }


}
