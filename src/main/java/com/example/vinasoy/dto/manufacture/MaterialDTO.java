package com.example.vinasoy.dto.warehouse;

import com.example.vinasoy.dto.warehouse.MaterialWarehouse.MaterialCategoryResponseDTO;
import lombok.Data;

@Data
public class MaterialDTO {
    private String materialId;
    private String materialCategoryId;
    private String materialName;
    private String unit;
    private String note;

}
