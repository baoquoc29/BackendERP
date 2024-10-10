package com.example.vinasoy.dto.manufacture;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private String productId;
    private String productCategoryId;
    private String productName;
    private String productType;
    private Integer weight;
    private String unit;
    private String shape;
    private String packType;
    private Integer quantity;
    private BigDecimal unitPrice;
    private String exp;
}
