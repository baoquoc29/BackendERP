package com.example.vinasoy.dto.sales;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class PromotionsDTO {
    private String promotionId;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal discountAmount;
    private Integer discountPercentage;
    private Integer usageLimit;
    private String isActive;
    private String note;


}
