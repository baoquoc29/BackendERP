package com.example.vinasoy.dto.warehouse.MaterialWarehouse;

import com.example.vinasoy.dto.manufacture.MaterialDTO;
import com.example.vinasoy.dto.manufacture.MaterialResponseDTO;
import lombok.Data;

@Data
public class MaterialWarehouseResponseDTO {
    private String materialWarehouseId;
    private MaterialResponseDTO materialDTO;
    private Integer quantity;
    private String mwhStatus;
    private String note;
}
