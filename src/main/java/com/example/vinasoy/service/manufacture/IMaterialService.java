package com.example.vinasoy.service.manufacture;

import com.example.vinasoy.dto.manufacture.MaterialDTO;
import com.example.vinasoy.dto.manufacture.MaterialResponseDTO;

import java.util.List;

public interface IMaterialService {
    List<MaterialResponseDTO> findAll();
    MaterialResponseDTO getMaterialById (String id);
    MaterialDTO creatMaterial (MaterialDTO requestDTO);
    MaterialDTO updateMaterial (MaterialDTO requestDTO);
    void deleteMaterialById (String id);
}
