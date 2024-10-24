package com.example.vinasoy.dto.warehouse;

import lombok.Data;

import java.time.LocalDate;
@Data
public class MaterialreceiptnoteDTO {
    private String materialReceiptNoteId;
    private String supplierId;
    private String employeeId;
    private LocalDate dateOfEntry;
    private String note;

}
