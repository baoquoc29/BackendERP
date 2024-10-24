package com.example.vinasoy.entity.manufacture;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.weaver.ast.Or;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "ProductID")
    private String productId;

    @Column(name = "ProductCategoryID")
    private String productCategoryId;

    @Column(name = "ProductName")
    private String productName;

    @Column(name = "ProductType")
    private String productType;

    @Column(name = "Weight")
    private Integer weight;

    @Column(name = "Unit")
    private String unit;

    @Column(name = "Shape")
    private String shape;

    @Column(name = "PackType")
    private String packType;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "UnitPrice")
    private BigDecimal unitPrice;

    @Column(name = "EXP")
    private String exp;

}
