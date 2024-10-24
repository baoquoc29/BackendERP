package com.example.vinasoy.controller.manufacture;

import com.example.vinasoy.dto.manufacture.MaterialDTO;
import com.example.vinasoy.dto.manufacture.MaterialResponseDTO;
import com.example.vinasoy.response.ApiResponse;
import com.example.vinasoy.service.manufacture.IMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/materials")
public class MaterialController {
    @Autowired
    private IMaterialService service;

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<MaterialResponseDTO> materialDTOS = service.findAll();
        ApiResponse<List<MaterialResponseDTO>> response = new ApiResponse<>();
        response.setCode(HttpStatus.OK.value());
        response.setResult(materialDTOS);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById (@PathVariable String id) {
        MaterialResponseDTO responseDTO = service.getMaterialById(id);
        ApiResponse<MaterialResponseDTO> response = new ApiResponse<>();
        response.setCode(HttpStatus.OK.value());
        response.setResult(responseDTO);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<?> createMaterial (@RequestBody MaterialDTO requestDTO) {
        MaterialDTO createMaterial = service.creatMaterial(requestDTO);
        ApiResponse<MaterialDTO> response = new ApiResponse<>();
        response.setCode(HttpStatus.CREATED.value());
        response.setResult(createMaterial);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping
    public ResponseEntity<?> updateMaterial(@RequestBody MaterialDTO requestDTO) {
        MaterialDTO updateMaterial = service.updateMaterial(requestDTO);
        ApiResponse<MaterialDTO> response = new ApiResponse<>();
        response.setCode(HttpStatus.OK.value());
        response.setResult(updateMaterial);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMaterial (@PathVariable String id) {
        service.deleteMaterialById(id);
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setResult("Material deleted successfully.");
        apiResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }
}
