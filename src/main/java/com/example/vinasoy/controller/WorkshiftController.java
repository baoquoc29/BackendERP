package com.example.vinasoy.controller;

import com.example.vinasoy.dto.employee.WorkshiftDTO;
import com.example.vinasoy.response.ApiResponse;
import com.example.vinasoy.service.employees.WorkshiftService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/workshifts")
public class WorkshiftController {

    private final WorkshiftService workshiftService;

    public WorkshiftController(WorkshiftService workshiftService) {
        this.workshiftService = workshiftService;
    }

    @PostMapping
    public ResponseEntity<?> createWorkshift(@RequestBody WorkshiftDTO workshiftDTO) {
        WorkshiftDTO createdWorkshift = workshiftService.createWorkshift(workshiftDTO);
        ApiResponse<WorkshiftDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(createdWorkshift);
        apiResponse.setCode(HttpStatus.CREATED.value());
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @GetMapping
    public ResponseEntity<?> getAllWorkshifts() {
        List<WorkshiftDTO> workshifts = workshiftService.getAllWorkshifts();
        ApiResponse<List<WorkshiftDTO>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(workshifts);
        apiResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getWorkshiftById(@PathVariable String id) {
        WorkshiftDTO workshiftDTO = workshiftService.getWorkshiftById(id);
        ApiResponse<WorkshiftDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(workshiftDTO);
        apiResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @PutMapping
    public ResponseEntity<?> updateWorkshift(@RequestBody WorkshiftDTO workshiftDTO) {
        WorkshiftDTO updatedWorkshift = workshiftService.updateWorkshift(workshiftDTO);
        ApiResponse<WorkshiftDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(updatedWorkshift);
        apiResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteWorkshift(@PathVariable String id) {
        workshiftService.deleteWorkshift(id);
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setResult("Workshift deleted successfully.");
        apiResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }
}

