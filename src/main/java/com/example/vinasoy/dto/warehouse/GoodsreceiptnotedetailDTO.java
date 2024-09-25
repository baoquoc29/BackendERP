package com.example.vinasoy.dto.warehouse;

import lombok.Data;

import java.time.LocalDate;
@Data
public class GoodsreceiptnotedetailDTO {
    private String goodsReceiptNoteId;
    private String productId;
    private Integer quantity;
    private LocalDate dateOfManufacture;
    private String note;


}
