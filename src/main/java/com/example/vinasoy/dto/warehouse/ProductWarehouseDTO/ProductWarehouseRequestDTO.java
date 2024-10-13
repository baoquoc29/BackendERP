package com.example.vinasoy.dto.warehouse.ProductWarehouseDTO;

import lombok.Data;

import java.time.LocalDate;
@Data
public class ProductWarehouseRequestDTO {
    private String productWarehouseId;
    private String productId;
    private Integer quantity;
    private LocalDate dateOfImport;
    private String productWhStatus;
}
