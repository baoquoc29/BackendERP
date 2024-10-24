package com.example.vinasoy.service.manufacture.impl;

import com.example.vinasoy.dto.manufacture.MaterialDTO;
import com.example.vinasoy.dto.manufacture.MaterialResponseDTO;
import com.example.vinasoy.dto.warehouse.MaterialWarehouse.MaterialCategoryResponseDTO;
import com.example.vinasoy.entity.warehouse.Material;
import com.example.vinasoy.entity.warehouse.Materialcategory;
import com.example.vinasoy.exception.AppException;
import com.example.vinasoy.exception.ErrorCode;
import com.example.vinasoy.repository.warehouse.IMaterialCategoryRepository;
import com.example.vinasoy.repository.warehouse.IMaterialRepository;
import com.example.vinasoy.service.manufacture.IMaterialService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MaterialService implements IMaterialService {
    @Autowired
    private final IMaterialRepository repository;
    private final ModelMapper modelMapper;
    private final IMaterialCategoryRepository materialCategoryRepository;

    @Override
    public List<MaterialResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(material -> {
                    MaterialResponseDTO materialDTO = modelMapper.map(material, MaterialResponseDTO.class);
                    Materialcategory materialcategory = material.getMaterialCategoryID();
                    if (materialcategory != null) {
                        MaterialCategoryResponseDTO dto = modelMapper.map(materialcategory, MaterialCategoryResponseDTO.class);
                        materialDTO.setMaterialCategoryId(dto);
                    }
                    return materialDTO;
                }).collect(Collectors.toList());
    }

    @Override
    public MaterialResponseDTO getMaterialById(String id) {
        Material material = repository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));
        MaterialResponseDTO materialDTO = modelMapper.map(material, MaterialResponseDTO.class);
        Materialcategory materialcategory = material.getMaterialCategoryID();
        if (materialcategory != null) {
            MaterialCategoryResponseDTO dto = modelMapper.map(materialcategory, MaterialCategoryResponseDTO.class);
            materialDTO.setMaterialCategoryId(dto);
        }
        return materialDTO;
    }

    private String generateProductWarehouseId() {
        return repository.findAll()
                .stream()
                .map(Material::getMaterialID)
                .max(String::compareTo)
                .map(currentMaxId -> {
                    int currentNumber = Integer.parseInt(currentMaxId.split("-")[1]);
                    return String.format("MAT-%04d", currentNumber + 1); // Tạo ID mới
                })
                .orElse("MAT-0001"); // Nếu không có kho sản phầm nào, bắt đầu từ PWH-0001
    }

    @Override
    public MaterialDTO creatMaterial(MaterialDTO requestDTO) {
        String materialId = generateProductWarehouseId();
        requestDTO.setMaterialId(materialId);
        Material material = modelMapper.map(requestDTO, Material.class);
        material.setMaterialCategoryID(materialCategoryRepository.findOneById(requestDTO.getMaterialCategoryId()));
        Material saveMaterial = repository.save(material);
        return modelMapper.map(saveMaterial, MaterialDTO.class);
    }

    @Override
    public MaterialDTO updateMaterial(MaterialDTO requestDTO) {
        Material material = repository.findById(requestDTO.getMaterialId())
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));
        modelMapper.map(requestDTO, material);
        material.setMaterialCategoryID(materialCategoryRepository.findOneById(requestDTO.getMaterialCategoryId()));
        Material saveMaterial = repository.save(material);
        return modelMapper.map(saveMaterial, MaterialDTO.class);
    }

    @Override
    public void deleteMaterialById(String id) {
        repository.deleteById(id);
    }
}
