package com.example.vinasoy.service.warehouse;

import com.example.vinasoy.dto.warehouse.MaterialWarehouse.MaterialCategoryResponseDTO;

import java.util.List;

public interface IMaterialCategoryService {
    List<MaterialCategoryResponseDTO> findAll ();
}
