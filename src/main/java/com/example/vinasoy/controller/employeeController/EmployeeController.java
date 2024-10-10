package com.example.vinasoy.controller.employeeController;

import com.example.vinasoy.dto.employee.employeeDTO.EmployeeRequestDTO;
import com.example.vinasoy.dto.employee.employeeDTO.EmployeeResponseDTO;
import com.example.vinasoy.response.ApiResponse;
import com.example.vinasoy.service.employees.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<?> getAllInfoEmployee(){
        List<EmployeeResponseDTO> responseDTOList = employeeService.getAllInfoEmployee();
        ApiResponse<List<EmployeeResponseDTO>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(responseDTOList);
        apiResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable String id) {
        EmployeeResponseDTO employeeResponseDTO = employeeService.getEmployeeById(id);
        ApiResponse<EmployeeResponseDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(employeeResponseDTO);
        apiResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @PutMapping()
    public ResponseEntity<?> updateEmployee( @RequestBody EmployeeRequestDTO updateDTO) {
        EmployeeResponseDTO updatedEmployee = employeeService.updateEmployee(updateDTO);
        ApiResponse<EmployeeResponseDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(updatedEmployee);
        apiResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO) {
        EmployeeResponseDTO createdEmployee = employeeService.createEmployee(employeeRequestDTO);
        ApiResponse<EmployeeResponseDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(createdEmployee);
        apiResponse.setCode(HttpStatus.CREATED.value());
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<EmployeeResponseDTO>>> searchEmployees(@RequestParam String keywords) {
        List<EmployeeResponseDTO> employeeList = employeeService.searchEmployees(keywords);
        ApiResponse<List<EmployeeResponseDTO>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(employeeList);
        apiResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

}
