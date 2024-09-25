package com.example.vinasoy.dto.warehouse;

import lombok.Data;

import java.time.LocalDate;
@Data
public class ProductwarehouseDTO {
    private String productWarehouseId;
    private String productId;
    private Integer quantity;
    private LocalDate dateOfImport;
    private String productWhStatus;


}
