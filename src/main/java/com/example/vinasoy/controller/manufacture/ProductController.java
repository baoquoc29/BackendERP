package com.example.vinasoy.controller.manufacture;

import com.example.vinasoy.dto.manufacture.ProductDTO;
import com.example.vinasoy.response.ApiResponse;
import com.example.vinasoy.service.manufacture.impl.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<ProductDTO> productDTOS = productService.findAll();
        ApiResponse<List<ProductDTO>> response = new ApiResponse<>();
        response.setCode(HttpStatus.OK.value());
        response.setResult(productDTOS);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
