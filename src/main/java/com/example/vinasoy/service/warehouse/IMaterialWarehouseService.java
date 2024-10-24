package com.example.vinasoy.service.warehouse;

import com.example.vinasoy.dto.warehouse.MaterialWarehouse.MaterialWarehouseRequestDTO;
import com.example.vinasoy.dto.warehouse.MaterialWarehouse.MaterialWarehouseResponseDTO;

import java.util.List;

public interface IMaterialWarehouseService {
    List<MaterialWarehouseResponseDTO> findAll ();
    MaterialWarehouseResponseDTO getMaterialWarehouseById (String id);

    MaterialWarehouseResponseDTO createMaterialWarehouse(MaterialWarehouseRequestDTO requestDTO);
    MaterialWarehouseResponseDTO updateMaterialWarehouse (MaterialWarehouseRequestDTO requestDTO);
    void deleteMaterialWarehouseById (String id);
}
