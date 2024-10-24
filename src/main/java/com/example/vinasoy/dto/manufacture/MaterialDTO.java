package com.example.vinasoy.dto.manufacture;

import com.example.vinasoy.dto.warehouse.MaterialWarehouse.MaterialCategoryResponseDTO;
import com.example.vinasoy.entity.warehouse.Materialcategory;
import lombok.Data;

@Data
public class MaterialDTO {
    private String materialId;
    private String materialCategoryId;
    private String materialName;
    private String unit;
    private String note;

}
