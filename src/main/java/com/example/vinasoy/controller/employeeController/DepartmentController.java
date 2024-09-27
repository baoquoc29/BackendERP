package com.example.vinasoy.controller.employeeController;

import com.example.vinasoy.dto.employee.DepartmentDTO;
import com.example.vinasoy.response.ApiResponse;
import com.example.vinasoy.entity.employee.Department;
import com.example.vinasoy.service.employees.DepartmentService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    @PostMapping
    public ResponseEntity<?> createDepartment(@RequestParam @NotNull String departmentName) {
        ApiResponse<Department> apiResponse = new ApiResponse<>();  // Sửa ở đây
        departmentService.createDepartment(departmentName);
        apiResponse.setCode(200);
        apiResponse.setMessage("Department created successfully");
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }


    @DeleteMapping("/{departmentId}")
    public ResponseEntity<?> deleteDepartment(@PathVariable String departmentId) {
            departmentService.deleteDepartment(departmentId);
            ApiResponse<String> apiResponse = new ApiResponse<>();
            apiResponse.setMessage("Department deleted with ID: " + departmentId);
            apiResponse.setCode(HttpStatus.OK.value());
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


    @PutMapping("/{departmentId}")
    public ResponseEntity<?> updateDepartment(
            @PathVariable String departmentId,
            @RequestParam String newDepartmentName) {
        departmentService.updateDepartment(departmentId, newDepartmentName);
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setMessage("Department updated successfully");
        apiResponse.setCode(HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<ApiResponse<List<DepartmentDTO>>> getAllDepartments() {
        List<DepartmentDTO> departments = departmentService.getAllDepartments();
        ApiResponse<List<DepartmentDTO>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(departments);
        apiResponse.setCode(HttpStatus.OK.value());
        apiResponse.setMessage("List of departments retrieved successfully");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<?> getDepartmentById(@PathVariable String departmentId) {
        DepartmentDTO departmentDTO = departmentService.getDepartmentsById(departmentId);
        ApiResponse<DepartmentDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(departmentDTO);
        apiResponse.setCode(HttpStatus.OK.value());
        apiResponse.setMessage("Department retrieved successfully");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
