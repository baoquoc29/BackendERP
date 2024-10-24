package com.example.vinasoy.service.warehouse.Impl;

import com.example.vinasoy.dto.manufacture.MaterialDTO;
import com.example.vinasoy.dto.manufacture.MaterialResponseDTO;
import com.example.vinasoy.dto.warehouse.MaterialWarehouse.MaterialCategoryResponseDTO;
import com.example.vinasoy.dto.warehouse.MaterialWarehouse.MaterialWarehouseRequestDTO;
import com.example.vinasoy.dto.warehouse.MaterialWarehouse.MaterialWarehouseResponseDTO;
import com.example.vinasoy.entity.warehouse.Material;
import com.example.vinasoy.entity.warehouse.Materialwarehouse;
import com.example.vinasoy.exception.AppException;
import com.example.vinasoy.exception.ErrorCode;
import com.example.vinasoy.repository.warehouse.IMaterialRepository;
import com.example.vinasoy.repository.warehouse.IMaterialWarehouseRepository;
import com.example.vinasoy.service.warehouse.IMaterialWarehouseService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MaterialWarehouseService implements IMaterialWarehouseService {

    private final IMaterialWarehouseRepository materialWarehouseRepository;
    private final IMaterialRepository materialRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<MaterialWarehouseResponseDTO> findAll() {
        return materialWarehouseRepository.findAll().stream()
                .map(materialwarehouse -> {
                    MaterialWarehouseResponseDTO dto = modelMapper.map(materialwarehouse, MaterialWarehouseResponseDTO.class);
                    Material material = materialwarehouse.getMaterialID();
                    if (material != null) {
                        MaterialResponseDTO materialDTO = modelMapper.map(material, MaterialResponseDTO.class);
                        dto.setMaterialDTO(materialDTO);
                    }
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public MaterialWarehouseResponseDTO getMaterialWarehouseById(String id) {
        Materialwarehouse materialwarehouse = materialWarehouseRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));
        MaterialWarehouseResponseDTO dto = modelMapper.map(materialwarehouse, MaterialWarehouseResponseDTO.class);
        Material material = materialwarehouse.getMaterialID();
        if (material != null) {
            MaterialResponseDTO materialDTO = modelMapper.map(material, MaterialResponseDTO.class);
            dto.setMaterialDTO(materialDTO);
        }
        return dto;
    }

    private String generateMaterialWarehouseId() {
        return materialWarehouseRepository.findAll()
                .stream()
                .map(Materialwarehouse::getMaterialWarehouseID)
                .max(String::compareTo)
                .map(currentMaxId -> {
                    int currentNumber = Integer.parseInt(currentMaxId.split("-")[1]);
                    return String.format("MWH-%04d", currentNumber + 1); // Tạo ID mới
                })
                .orElse("MWH-0001"); // Nếu không có kho sản phầm nào, bắt đầu từ PWH-0001
    }

    @Override
    public MaterialWarehouseResponseDTO createMaterialWarehouse(MaterialWarehouseRequestDTO requestDTO) {
        String materialWarehouseId = generateMaterialWarehouseId();
        requestDTO.setMaterialWarehouseId(materialWarehouseId);
        Materialwarehouse materialwarehouse = modelMapper.map(requestDTO, Materialwarehouse.class);
        materialwarehouse.setMaterialID(materialRepository.findOneById(requestDTO.getMaterialId()));
        Materialwarehouse saveMaterialWarehouse = materialWarehouseRepository.save(materialwarehouse);
        return modelMapper.map(saveMaterialWarehouse, MaterialWarehouseResponseDTO.class);
    }

    @Override
    public MaterialWarehouseResponseDTO updateMaterialWarehouse(MaterialWarehouseRequestDTO requestDTO) {
        Materialwarehouse materialwarehouse = materialWarehouseRepository.findById(requestDTO.getMaterialWarehouseId())
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));
        Material material = materialRepository.findOneById(requestDTO.getMaterialId());
        modelMapper.map(requestDTO, materialwarehouse);
        materialwarehouse.setMaterialID(material);
        Materialwarehouse updatedMaterialWarehouse = materialWarehouseRepository.save(materialwarehouse);
        return modelMapper.map(updatedMaterialWarehouse, MaterialWarehouseResponseDTO.class);
    }

    @Override
    public void deleteMaterialWarehouseById(String id) {
        materialWarehouseRepository.deleteById(id);
    }
}
