package com.example.vinasoy.dto.warehouse;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class MaterialreceiptnotedetailDTO {
    private String materialReceiptNoteId;
    private String materialId;
    private Integer quantity;
    private BigDecimal unitPrice;
    private String note;

}
