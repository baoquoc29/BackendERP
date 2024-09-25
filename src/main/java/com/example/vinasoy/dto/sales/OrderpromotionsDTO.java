package com.example.vinasoy.dto.sales;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class OrderpromotionsDTO {
    private String orderPromotionId;
    private String promotionId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String promotionType;
    private BigDecimal discountAmount;
    private Integer discountPercentage;
    private BigDecimal minimumOrderValue;
    private Integer usageLimit;
    private String isActive;
    private String note;

}
