package com.example.vinasoy.controller;

import com.example.vinasoy.dto.employee.DepartmentDTO;
import com.example.vinasoy.response.ApiResponse;
import com.example.vinasoy.service.employees.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<?> createDepartment(@RequestBody DepartmentDTO departmentDTO) {
        DepartmentDTO createdDepartment = departmentService.createDepartment(departmentDTO);
        ApiResponse<DepartmentDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(createdDepartment);
        apiResponse.setCode(HttpStatus.CREATED.value());
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @GetMapping
    public ResponseEntity<?> getAllDepartments() {
        List<DepartmentDTO> departments = departmentService.getAllDepartments();
        ApiResponse<List<DepartmentDTO>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(departments);
        apiResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDepartmentById(@PathVariable String id) {
        DepartmentDTO departmentDTO = departmentService.getDepartmentById(id);
        ApiResponse<DepartmentDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(departmentDTO);
        apiResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @PutMapping
    public ResponseEntity<?> updateDepartment(@RequestBody DepartmentDTO departmentDTO) {
        DepartmentDTO updatedDepartment = departmentService.updateDepartment(departmentDTO);
        ApiResponse<DepartmentDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(updatedDepartment);
        apiResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable String id) {
        departmentService.deleteDepartment(id);
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setResult("Department deleted successfully.");
        apiResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }
}
