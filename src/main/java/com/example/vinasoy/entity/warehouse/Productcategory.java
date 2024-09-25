package com.example.vinasoy.entity.warehouse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "productcategory")
public class Productcategory {
    @Id
    @Column(name = "ProductCategoryID", nullable = false, length = 10)
    private String productCategoryID;

    @Column(name = "ProductCategoryName")
    private String productCategoryName;

    @Column(name = "Note")
    private String note;

}