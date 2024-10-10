package com.example.vinasoy.entity.manufacture;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "productcategory")
public class Productcategory {
    @Id
    @Column(name = "ProductCategoryID")
    private String productCategoryId;

    @Column(name = "ProductCategoryName")
    private String productCategoryName;

    @Column(name = "Note")
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
