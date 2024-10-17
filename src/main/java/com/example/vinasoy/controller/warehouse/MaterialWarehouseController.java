package com.example.vinasoy.controller.warehouse;

import com.example.vinasoy.dto.warehouse.MaterialWarehouse.MaterialWarehouseRequestDTO;
import com.example.vinasoy.dto.warehouse.MaterialWarehouse.MaterialWarehouseResponseDTO;
import com.example.vinasoy.response.ApiResponse;
import com.example.vinasoy.service.warehouse.IMaterialWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/material-warehouse")
public class MaterialWarehouseController {
    @Autowired
    private IMaterialWarehouseService service;
    @GetMapping
    public ResponseEntity<?> findAll () {
        List<MaterialWarehouseResponseDTO> responseDTOS = service.findAll();
        ApiResponse<List<MaterialWarehouseResponseDTO>> response = new ApiResponse<>();
        response.setCode(HttpStatus.OK.value());
        response.setResult(responseDTOS);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById (@PathVariable String id) {
        MaterialWarehouseResponseDTO responseDTO = service.getMaterialWarehouseById(id);
        ApiResponse<MaterialWarehouseResponseDTO> response = new ApiResponse<>();
        response.setCode(HttpStatus.OK.value());
        response.setResult(responseDTO);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<?> createProductWarehouse (@RequestBody MaterialWarehouseRequestDTO requestDTO) {
        MaterialWarehouseResponseDTO createMaterialWarehouse = service.createMaterialWarehouse(requestDTO);
        ApiResponse<MaterialWarehouseResponseDTO> response = new ApiResponse<>();
        response.setCode(HttpStatus.CREATED.value());
        response.setResult(createMaterialWarehouse);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping
    public ResponseEntity<?> updateProductWarehouse (@RequestBody MaterialWarehouseRequestDTO requestDTO) {
        MaterialWarehouseResponseDTO updateProductWarehouse = service.updateMaterialWarehouse(requestDTO);
        ApiResponse<MaterialWarehouseResponseDTO> response = new ApiResponse<>();
        response.setCode(HttpStatus.OK.value());
        response.setResult(updateProductWarehouse);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductWarehouse (@PathVariable String id) {
        service.deleteMaterialWarehouseById(id);
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setResult("Material warehouse deleted successfully.");
        apiResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }
}
