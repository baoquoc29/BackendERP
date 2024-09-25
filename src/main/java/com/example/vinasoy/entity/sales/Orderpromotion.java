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
@Table(name = "orderpromotions")
public class Orderpromotion {
    @Id
    @Column(name = "OrderPromotionID", nullable = false, length = 10)
    private String orderPromotionID;

    @Column(name = "StartDate")
    private LocalDate startDate;

    @Column(name = "EndDate")
    private LocalDate endDate;

    @Column(name = "PromotionType", length = 20)
    private String promotionType;

    @Column(name = "DiscountAmount", precision = 10, scale = 2)
    private BigDecimal discountAmount;

    @Column(name = "DiscountPercentage")
    private Integer discountPercentage;

    @Column(name = "MinimumOrderValue", precision = 10, scale = 2)
    private BigDecimal minimumOrderValue;

    @ColumnDefault("0")
    @Column(name = "UsageLimit")
    private Integer usageLimit;

    @Column(name = "IsActive", length = 50)
    private String isActive;

    @Lob
    @Column(name = "Note")
    private String note;

}