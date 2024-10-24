package com.example.vinasoy.service.manufacture.impl;

import com.example.vinasoy.dto.manufacture.ProductDTO;
import com.example.vinasoy.repository.manufacture.ProductRepository;
import com.example.vinasoy.service.manufacture.IProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public List<ProductDTO> findAll() {
        return repository.findAll().stream()
                .map(product -> {
                    ProductDTO dto = modelMapper.map(product, ProductDTO.class);
                    return dto;
                }).collect(Collectors.toList());
    }
}
