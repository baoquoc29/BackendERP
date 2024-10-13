package com.example.vinasoy.entity.warehouse;

import com.example.vinasoy.entity.manufacture.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "goodsissuenotedetail")
public class Goodsissuenotedetail {
    @EmbeddedId
    private GoodsissuenotedetailId id;

    @MapsId("productID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ProductID", nullable = false)
    private Product productID;

    @MapsId("goodsIssueNoteID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "GoodsIssueNoteID", nullable = false)
    private Goodsissuenote goodsIssueNoteID;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "UnitPrice", precision = 18, scale = 2)
    private BigDecimal unitPrice;

    @Size(max = 50)
    @Column(name = "GINDStatus", length = 50)
    private String gINDStatus;

    @Size(max = 255)
    @Column(name = "Note")
    private String note;

}