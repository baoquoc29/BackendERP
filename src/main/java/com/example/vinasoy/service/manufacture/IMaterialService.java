package com.example.vinasoy.service.manufacture;

import com.example.vinasoy.dto.warehouse.MaterialDTO;

import java.util.List;

public interface IMaterialService {
    List<MaterialDTO> findAll();
}
