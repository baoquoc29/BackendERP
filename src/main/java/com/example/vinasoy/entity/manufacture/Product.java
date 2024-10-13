package com.example.vinasoy.entity.manufacture;

import com.example.vinasoy.entity.sales.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )

    @JsonManagedReference
    private Set<Orderdetail> orderdetails = new HashSet<>();


    public void addOrderDetail(Orderdetail orderdetail) {
        if(orderdetail != null) {
            orderdetails.add(orderdetail);
            orderdetail.setProduct(this);
        }
    }

    public void removeOrderDetail(Orderdetail orderdetail) {
        if(orderdetail != null) {
            orderdetails.remove(orderdetail);
            orderdetail.setProduct(null);
        }
    }

    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )

    @JsonManagedReference
    private Set<Invoicedetails> invoicedetails = new HashSet<>();


    public void addInvoiceDetail(Invoicedetails invoicedetail) {
        if(invoicedetail != null) {
            invoicedetails.add(invoicedetail);
            invoicedetail.setProduct(this);
        }
    }

    public void removeInvoiceDetail(Invoicedetails invoicedetail) {
        if(invoicedetail != null) {
            invoicedetails.remove(invoicedetail);
            invoicedetail.setProduct(null);
        }
    }

    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )

    @JsonManagedReference
    private Set<Goodsissue> goodsissues = new HashSet<>();


    public void addGoodIssue(Goodsissue goodsissue) {
        if(goodsissue != null) {
            goodsissues.add(goodsissue);
            goodsissue.setProduct(this);
        }
    }

    public void removeGoodIssue(Goodsissue goodsissue) {
        if(goodsissue != null) {
            goodsissues.remove(goodsissue);
            goodsissue.setProduct(null);
        }
    }

    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )

    @JsonManagedReference
    private Set<Goodsreceipt> goodsreceipts = new HashSet<>();


    public void addGoodsreceipts(Goodsreceipt goodsreceipt) {
        if(goodsreceipt != null) {
            goodsreceipts.add(goodsreceipt);
            goodsreceipt.setProduct(this);
        }
    }

    public void removeGoodsreceipts(Goodsreceipt goodsreceipt) {
        if(goodsreceipt != null) {
            goodsreceipts.remove(goodsreceipt);
            goodsreceipt.setProduct(null);
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productType='" + productType + '\'' +
                ", weight=" + weight +
                ", unit='" + unit + '\'' +
                ", shape='" + shape + '\'' +
                ", packType='" + packType + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", exp='" + exp + '\'' +
                '}';
    }
}
