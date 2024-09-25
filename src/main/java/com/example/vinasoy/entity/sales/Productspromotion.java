package com.example.vinasoy.entity.sales;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "productspromotions")
public class Productspromotion {
    @Id
    @Column(name = "ProductPromotionID", nullable = false, length = 10)
    private String productPromotionID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PromotionID")
    private Promotion promotionID;

}