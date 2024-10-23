package com.example.vinasoy.controller.manufacture;

import com.example.vinasoy.dto.warehouse.MaterialDTO;
import com.example.vinasoy.response.ApiResponse;
import com.example.vinasoy.service.manufacture.IMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/materials")
public class MaterialController {
    @Autowired
    private IMaterialService service;

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<MaterialDTO> materialDTOS = service.findAll();
        ApiResponse<List<MaterialDTO>> response = new ApiResponse<>();
        response.setCode(HttpStatus.OK.value());
        response.setResult(materialDTOS);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
