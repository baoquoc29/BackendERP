package com.example.vinasoy.service.manufacture;

import com.example.vinasoy.dto.manufacture.ProductDTO;

import java.util.List;

public interface IProductService {
    List<ProductDTO> findAll();
}
