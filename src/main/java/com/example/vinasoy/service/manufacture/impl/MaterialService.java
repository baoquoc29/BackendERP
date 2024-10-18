package com.example.vinasoy.service.manufacture.impl;

import com.example.vinasoy.dto.warehouse.MaterialDTO;
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

    @Override
    public List<MaterialDTO> findAll() {
        return repository.findAll().stream()
                .map(material -> {
                    return modelMapper.map(material, MaterialDTO.class);
                }).collect(Collectors.toList());
    }
}
