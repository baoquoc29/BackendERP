package com.example.vinasoy.dto.warehouse.MaterialWarehouse;

import lombok.Data;

@Data
public class MaterialWarehouseRequestDTO {
    private String materialWarehouseId;
    private String materialId;
    private Integer quantity;
    private String mwhStatus;
    private String note;

}
