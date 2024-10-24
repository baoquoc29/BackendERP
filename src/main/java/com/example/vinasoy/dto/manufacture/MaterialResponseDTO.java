package com.example.vinasoy.dto.manufacture;

import com.example.vinasoy.dto.warehouse.MaterialWarehouse.MaterialCategoryResponseDTO;
import lombok.Data;

@Data
public class MaterialResponseDTO {
    private String materialId;
    private MaterialCategoryResponseDTO materialCategoryId;
    private String materialName;
    private String unit;
    private String note;
}
