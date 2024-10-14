package com.example.vinasoy.service.warehouse.Impl;

import com.example.vinasoy.dto.manufacture.ProductDTO;
import com.example.vinasoy.dto.warehouse.ProductWarehouseDTO.ProductWarehouseRequestDTO;
import com.example.vinasoy.dto.warehouse.ProductWarehouseDTO.ProductWarehouseResponseDTO;
import com.example.vinasoy.entity.manufacture.Product;
import com.example.vinasoy.entity.warehouse.Productwarehouse;
import com.example.vinasoy.exception.AppException;
import com.example.vinasoy.exception.ErrorCode;
import com.example.vinasoy.repository.manufacture.ProductRepository;
import com.example.vinasoy.repository.warehouse.ProductWarehouseRepository;
import com.example.vinasoy.service.warehouse.IProductWarehouseService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductWarehouseService implements IProductWarehouseService {

    private final ProductWarehouseRepository repository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ProductWarehouseResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(productwarehouse -> {
                    ProductWarehouseResponseDTO dto = modelMapper.map(productwarehouse, ProductWarehouseResponseDTO.class);
                    Product product = productwarehouse.getProductID();
                    if (product != null) {
                        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
                        dto.setProductDTO(productDTO);
                    }
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ProductWarehouseResponseDTO getProductWarehouseById(String id) {
        Productwarehouse productwarehouse = repository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));
        ProductWarehouseResponseDTO dto = modelMapper.map(productwarehouse, ProductWarehouseResponseDTO.class);
        Product product = productwarehouse.getProductID();
        if (product != null) {
            ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
            dto.setProductDTO(productDTO);
        }
        return dto;
    }

    private String generateProductWarehouseId() {
        return repository.findAll()
                .stream()
                .map(Productwarehouse::getProductWarehouseID)
                .max(String::compareTo)
                .map(currentMaxId -> {
                    int currentNumber = Integer.parseInt(currentMaxId.split("-")[1]);
                    return String.format("PWH-%04d", currentNumber + 1); // Tạo ID mới
                })
                .orElse("PWH-0001"); // Nếu không có kho sản phầm nào, bắt đầu từ PWH-0001
    }

    @Override
    public ProductWarehouseResponseDTO createProductWarehouse(ProductWarehouseRequestDTO requestDTO) {
        String productWarehouseId = generateProductWarehouseId();
        requestDTO.setProductWarehouseId(productWarehouseId);
        Productwarehouse productwarehouse = modelMapper.map(requestDTO, Productwarehouse.class);
        productwarehouse.setProductID(productRepository.findOneById(requestDTO.getProductId()));
        Productwarehouse saveProductWarehouse = repository.save(productwarehouse);
        return modelMapper.map(saveProductWarehouse, ProductWarehouseResponseDTO.class);
    }

    @Override
    public ProductWarehouseResponseDTO updateProductWarehouse(ProductWarehouseRequestDTO requestDTO) {
        Productwarehouse productwarehouse = repository.findById(requestDTO.getProductWarehouseId())
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));
        modelMapper.map(requestDTO, productwarehouse);
        Productwarehouse updatedProductWarehouse = repository.save(productwarehouse);
        return modelMapper.map(updatedProductWarehouse, ProductWarehouseResponseDTO.class);
    }

    @Override
    public void deleteProductWarehouseById(String id) {
        repository.deleteById(id);
    }
}
