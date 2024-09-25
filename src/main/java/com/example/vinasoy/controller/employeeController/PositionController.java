package com.example.vinasoy.controller.employeeController;
import com.example.vinasoy.dto.employee.ApiResponse;
import com.example.vinasoy.dto.employee.DepartmentDTO;
import com.example.vinasoy.dto.employee.PositionsDTO;
import com.example.vinasoy.entity.employee.Department;
import com.example.vinasoy.service.employees.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/positions")
public class PositionController {

    @Autowired
    private PositionService positionService;


    @PostMapping
    public ResponseEntity<?> createPosition(@RequestBody PositionsDTO positionsDTO) {
        ApiResponse<Department> apiResponse = new ApiResponse<>();  // Sửa ở đây
        positionService.createPosition(positionsDTO);
        apiResponse.setCode(200);
        apiResponse.setMessage("Department created successfully");
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePosition(@PathVariable("id") String positionId) {
        positionService.deletePosition(positionId);
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setMessage("Position deleted with ID: " + positionId);
        apiResponse.setCode(HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updatePosition(
            @RequestBody PositionsDTO positionsDTO) {
        ApiResponse<Department> apiResponse = new ApiResponse<>();  // Sửa ở đây
        positionService.updatePosition(positionsDTO);
        apiResponse.setCode(200);
        apiResponse.setMessage("Position update successfully");
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);

    }


    @GetMapping
    public ResponseEntity<?> getAllPositions() {
        List<PositionsDTO> positions = positionService.getAllPositions();
        ApiResponse<List<PositionsDTO>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(positions);
        apiResponse.setCode(HttpStatus.OK.value());
        apiResponse.setMessage("List of position retrieved successfully");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPositionById(@PathVariable("id") String positionId) {
        PositionsDTO positionDTO = positionService.getPositionById(positionId);
        ApiResponse<PositionsDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(positionDTO);
        apiResponse.setCode(HttpStatus.OK.value());
        apiResponse.setMessage("Position retrieved successfully");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}

