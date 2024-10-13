package com.example.vinasoy.dto.sales;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GoodsissueDTO {
    private String goodsIssueId;
    private String invoiceId;
    private String employeeId;
    private String productId;
    private Integer quantityExported;
    private BigDecimal exportPrice;
    private LocalDate exportDate;
    private String note;
}
