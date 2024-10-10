package com.example.vinasoy.dto.warehouse;

import lombok.Data;

@Data
public class MaterialwarehouseDTO {
    private String materialWarehouseId;
    private String materialId;
    private Integer quantity;
    private String mwhStatus;
    private String note;

}
