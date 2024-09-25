package com.example.vinasoy.dto.warehouse;

import lombok.Data;

@Data
public class MaterialissuenotedetailDTO {
    private String materialIssueNoteId;
    private String materialId;
    private Integer quantity;
    private String mIsNStatus;
    private String note;

}
