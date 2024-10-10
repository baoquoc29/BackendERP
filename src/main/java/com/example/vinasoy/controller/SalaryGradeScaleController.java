package com.example.vinasoy.controller;

import com.example.vinasoy.dto.employee.SalaryGradeScaleDTO;
import com.example.vinasoy.response.ApiResponse;
import com.example.vinasoy.service.employees.SalarygradescaleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/salary-grade-scales")
public class SalaryGradeScaleController {

    private final SalarygradescaleService salaryGradeScaleService;

    public SalaryGradeScaleController(SalarygradescaleService salaryGradeScaleService) {
        this.salaryGradeScaleService = salaryGradeScaleService;
    }

    @PostMapping
    public ResponseEntity<?> createSalaryGradeScale(@RequestBody SalaryGradeScaleDTO salaryGradeScaleDTO) {
        SalaryGradeScaleDTO createdSalaryGradeScale = salaryGradeScaleService.createSalaryGradeScale(salaryGradeScaleDTO);
        ApiResponse<SalaryGradeScaleDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(createdSalaryGradeScale);
        apiResponse.setCode(HttpStatus.CREATED.value());
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @GetMapping
    public ResponseEntity<?> getAllSalaryGradeScales() {
        List<SalaryGradeScaleDTO> salaryGradeScales = salaryGradeScaleService.getAllSalaryGradeScales();
        ApiResponse<List<SalaryGradeScaleDTO>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(salaryGradeScales);
        apiResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSalaryGradeScaleById(@PathVariable String id) {
        SalaryGradeScaleDTO salaryGradeScaleDTO = salaryGradeScaleService.getSalaryGradeScaleById(id);
        ApiResponse<SalaryGradeScaleDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(salaryGradeScaleDTO);
        apiResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @PutMapping
    public ResponseEntity<?> updateSalaryGradeScale(@RequestBody SalaryGradeScaleDTO salaryGradeScaleDTO) {
        SalaryGradeScaleDTO updatedSalaryGradeScale = salaryGradeScaleService.updateSalaryGradeScale(salaryGradeScaleDTO);
        ApiResponse<SalaryGradeScaleDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(updatedSalaryGradeScale);
        apiResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchSalaryGradeScale(@RequestParam String query) {
        List<SalaryGradeScaleDTO> salaryGradeScales = salaryGradeScaleService.searchSalaryGradeScales(query);
        ApiResponse<List<SalaryGradeScaleDTO>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(salaryGradeScales);
        apiResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSalaryGradeScale(@PathVariable String id) {
        salaryGradeScaleService.deleteSalaryGradeScale(id);
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setResult("Salary Grade Scale deleted successfully.");
        apiResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }
}
