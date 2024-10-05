package com.example.vinasoy.entity.sales;

import com.example.vinasoy.entity.warehouse.Productcategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @Size(max = 10)
    @Column(name = "ProductID", nullable = false, length = 10)
    private String productID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductCategoryID")
    private Productcategory productCategoryID;

    @Size(max = 255)
    @Column(name = "ProductName")
    private String productName;

    @Size(max = 255)
    @Column(name = "ProductType")
    private String productType;

    @Column(name = "Weight")
    private Integer weight;

    @Size(max = 50)
    @Column(name = "Unit", length = 50)
    private String unit;

    @Size(max = 55)
    @Column(name = "Shape", length = 55)
    private String shape;

    @Size(max = 50)
    @Column(name = "PackType", length = 50)
    private String packType;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "UnitPrice", precision = 18, scale = 2)
    private BigDecimal unitPrice;

    @Size(max = 100)
    @Column(name = "EXP", length = 100)
    private String exp;

}