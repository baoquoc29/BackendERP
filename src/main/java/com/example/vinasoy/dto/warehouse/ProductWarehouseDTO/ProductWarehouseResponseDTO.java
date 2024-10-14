package com.example.vinasoy.dto.warehouse.ProductWarehouseDTO;

import com.example.vinasoy.dto.manufacture.ProductDTO;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ProductWarehouseResponseDTO {
    private String productWarehouseId;
    private ProductDTO productDTO;
    private Integer quantity;
    private LocalDate dateOfImport;
    private String productWhStatus;
}
