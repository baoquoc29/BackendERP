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
public class GoodsreceiptDTO {
    private String goodsReceiptId;
    private String employeeId;
    private String productId;
    private Integer quantityImported;
    private BigDecimal importPrice;
    private LocalDate importDate;
    private String note;
}
