package com.example.vinasoy.entity.manufacture;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
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


}
