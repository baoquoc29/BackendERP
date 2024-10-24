package com.example.vinasoy.controller.warehouse;

import com.example.vinasoy.dto.warehouse.MaterialWarehouse.MaterialCategoryResponseDTO;
import com.example.vinasoy.response.ApiResponse;
import com.example.vinasoy.service.warehouse.IMaterialCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/material-category")
public class MaterialCategoryController {
    @Autowired
    private IMaterialCategoryService service;
    @GetMapping
    public ResponseEntity<?> findAll () {
        List<MaterialCategoryResponseDTO> responseDTOS = service.findAll();
        ApiResponse<List<MaterialCategoryResponseDTO>> response = new ApiResponse<>();
        response.setCode(HttpStatus.OK.value());
        response.setResult(responseDTOS);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
