package com.example.vinasoy.dto.warehouse;

import lombok.Data;

@Data
public class ProductionwarehouseDTO {
    private String productionWarehouseId;
    private String semiFinishedProductId;
    private Integer quantity;
    private String productionWhStatus;
}
