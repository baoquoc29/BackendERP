package com.example.vinasoy.entity.sales;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "orderpromotiondetail")
public class Orderpromotiondetail {
    @Id
    @Column(name = "OrderPromotionDetailID", nullable = false, length = 10)
    private String orderPromotionDetailID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OrderID")
    private Order orderID;

}