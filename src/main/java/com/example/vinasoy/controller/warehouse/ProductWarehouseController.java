package com.example.vinasoy.controller.warehouse;

import com.example.vinasoy.dto.warehouse.ProductWarehouseDTO.ProductWarehouseRequestDTO;
import com.example.vinasoy.dto.warehouse.ProductWarehouseDTO.ProductWarehouseResponseDTO;
import com.example.vinasoy.response.ApiResponse;
import com.example.vinasoy.service.warehouse.IProductWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product-warehouse")
public class ProductWarehouseController {
    @Autowired
    private IProductWarehouseService productWarehouseService;

    @GetMapping
    public ResponseEntity<?> findAll () {
        List<ProductWarehouseResponseDTO> responseDTOS = productWarehouseService.findAll();
        ApiResponse<List<ProductWarehouseResponseDTO>> response = new ApiResponse<>();
        response.setCode(HttpStatus.OK.value());
        response.setResult(responseDTOS);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById (@PathVariable String id) {
        ProductWarehouseResponseDTO responseDTO = productWarehouseService.getProductWarehouseById(id);
        ApiResponse<ProductWarehouseResponseDTO> response = new ApiResponse<>();
        response.setCode(HttpStatus.OK.value());
        response.setResult(responseDTO);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<?> createProductWarehouse (@RequestBody ProductWarehouseRequestDTO requestDTO) {
        ProductWarehouseResponseDTO createProductWarehouse = productWarehouseService.createProductWarehouse(requestDTO);
        ApiResponse<ProductWarehouseResponseDTO> response = new ApiResponse<>();
        response.setCode(HttpStatus.CREATED.value());
        response.setResult(createProductWarehouse);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping
    public ResponseEntity<?> updateProductWarehouse (@RequestBody ProductWarehouseRequestDTO requestDTO) {
        ProductWarehouseResponseDTO updateProductWarehouse = productWarehouseService.updateProductWarehouse(requestDTO);
        ApiResponse<ProductWarehouseResponseDTO> response = new ApiResponse<>();
        response.setCode(HttpStatus.OK.value());
        response.setResult(updateProductWarehouse);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductWarehouse (@PathVariable String id) {
        productWarehouseService.deleteProductWarehouseById(id);
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setResult("Product warehouse deleted successfully.");
        apiResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }
}
