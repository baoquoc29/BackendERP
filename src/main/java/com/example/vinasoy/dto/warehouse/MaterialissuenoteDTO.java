package com.example.vinasoy.dto.warehouse;

import lombok.Data;

import java.time.LocalDate;
@Data
public class MaterialissuenoteDTO {
    private String materialIssueNoteId;
    private String employeeId;
    private LocalDate dateOfIssue;
    private String note;


}
