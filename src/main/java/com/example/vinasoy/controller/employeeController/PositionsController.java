package com.example.vinasoy.controller.employeeController;

import com.example.vinasoy.dto.employee.PositionsDTO;
import com.example.vinasoy.response.ApiResponse;
import com.example.vinasoy.service.employees.PositionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/positions")
public class PositionsController {

    private final PositionService positionsService;

    public PositionsController(PositionService positionsService) {
        this.positionsService = positionsService;
    }

    @PostMapping
    public ResponseEntity<?> createPosition(@RequestBody PositionsDTO positionsDTO) {
        PositionsDTO createdPosition = positionsService.createPosition(positionsDTO);
        ApiResponse<PositionsDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(createdPosition);
        apiResponse.setCode(HttpStatus.CREATED.value());
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @GetMapping
    public ResponseEntity<?> getAllPositions() {
        List<PositionsDTO> positions = positionsService.getAllPositions();
        ApiResponse<List<PositionsDTO>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(positions);
        apiResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPositionById(@PathVariable String id) {
        PositionsDTO positionsDTO = positionsService.getPositionById(id);
        ApiResponse<PositionsDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(positionsDTO);
        apiResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @PutMapping
    public ResponseEntity<?> updatePosition(@RequestBody PositionsDTO positionsDTO) {
        PositionsDTO updatedPosition = positionsService.updatePosition(positionsDTO);
        ApiResponse<PositionsDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(updatedPosition);
        apiResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePosition(@PathVariable String id) {
        positionsService.deletePosition(id);
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setResult("Position deleted successfully.");
        apiResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchPositions(@RequestParam("keyword") String keyword) {
        List<PositionsDTO> positions = positionsService.searchPositions(keyword);
        ApiResponse<List<PositionsDTO>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(positions);
        apiResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }
}
