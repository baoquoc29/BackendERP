package com.example.vinasoy.entity.sales;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "promotions")
public class Promotion {
    @Id
    @Column(name = "PromotionID", nullable = false, length = 10)
    private String promotionID;

    @Column(name = "StartDate")
    private LocalDate startDate;

    @Column(name = "EndDate")
    private LocalDate endDate;

    @Column(name = "DiscountAmount", precision = 10, scale = 2)
    private BigDecimal discountAmount;

    @Column(name = "DiscountPercentage")
    private Integer discountPercentage;

    @ColumnDefault("0")
    @Column(name = "UsageLimit")
    private Integer usageLimit;

    @Column(name = "IsActive")
    private String isActive;

    @Lob
    @Column(name = "Note")
    private String note;

}