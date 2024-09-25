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

    public String getMaterialReceiptNoteId() {
        return this.materialReceiptNoteId;
    }

    public void setMaterialReceiptNoteId(String materialReceiptNoteId) {
        this.materialReceiptNoteId = materialReceiptNoteId;
    }

    public String getMaterialId() {
        return this.materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return this.unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
