package com.example.vinasoy.service.warehouse.Impl;

import com.example.vinasoy.dto.warehouse.MaterialWarehouse.MaterialCategoryResponseDTO;
import com.example.vinasoy.repository.warehouse.IMaterialCategoryRepository;
import com.example.vinasoy.service.warehouse.IMaterialCategoryService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MaterialCategoryService implements IMaterialCategoryService {

    private final IMaterialCategoryRepository repository;
    private final ModelMapper modelMapper;
    @Override
    public List<MaterialCategoryResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(materialcategory -> {
                    return modelMapper.map(materialcategory, MaterialCategoryResponseDTO.class);
                })
                .collect(Collectors.toList());
    }
}
