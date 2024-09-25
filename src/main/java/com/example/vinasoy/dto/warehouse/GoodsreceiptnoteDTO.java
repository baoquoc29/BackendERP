package com.example.vinasoy.dto.warehouse;

import lombok.Data;

import java.time.LocalDate;
@Data
public class GoodsreceiptnoteDTO {
    private String goodsReceiptNoteId;
    private String employeeId;
    private LocalDate dateOfEntry;
    private String note;

}
