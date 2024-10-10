package com.example.vinasoy.dto.manufacture;

public class ProductcategoryDTO {
    private String productCategoryId;
    private String productCategoryName;
    private String note;

    public String getProductCategoryId() {
        return this.productCategoryId;
    }

    public void setProductCategoryId(String productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getProductCategoryName() {
        return this.productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
