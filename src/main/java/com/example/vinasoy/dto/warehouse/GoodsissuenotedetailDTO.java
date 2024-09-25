package com.example.vinasoy.dto.warehouse;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class GoodsissuenotedetailDTO {
    private String goodsIssueNoteId;
    private String productId;
    private Integer quantity;
    private BigDecimal unitPrice;
    private String gindStatus;
    private String note;


}
