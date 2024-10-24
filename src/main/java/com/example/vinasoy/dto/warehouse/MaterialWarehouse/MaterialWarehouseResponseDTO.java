package com.example.vinasoy.dto.warehouse.MaterialWarehouse;

import com.example.vinasoy.dto.warehouse.MaterialDTO;
import lombok.Data;

@Data
public class MaterialWarehouseResponseDTO {
    private String materialWarehouseId;
    private MaterialDTO materialDTO;
    private Integer quantity;
    private String mwhStatus;
    private String note;
}
