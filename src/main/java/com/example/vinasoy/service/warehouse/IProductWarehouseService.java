package com.example.vinasoy.service.warehouse;

import com.example.vinasoy.dto.warehouse.ProductWarehouseDTO.ProductWarehouseRequestDTO;
import com.example.vinasoy.dto.warehouse.ProductWarehouseDTO.ProductWarehouseResponseDTO;

import java.util.List;

public interface IProductWarehouseService {
    List<ProductWarehouseResponseDTO> findAll ();
    ProductWarehouseResponseDTO getProductWarehouseById (String id);

    ProductWarehouseResponseDTO createProductWarehouse(ProductWarehouseRequestDTO requestDTO);
    ProductWarehouseResponseDTO updateProductWarehouse (ProductWarehouseRequestDTO requestDTO);
    void deleteProductWarehouseById (String id);
}
