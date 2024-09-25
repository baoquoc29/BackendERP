package com.example.vinasoy.entity.warehouse;

import jakarta.persistence.*;
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

    @MapsId("goodsIssueNoteID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "GoodsIssueNoteID", nullable = false)
    private Goodsissuenote goodsIssueNoteID;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "UnitPrice", precision = 18, scale = 2)
    private BigDecimal unitPrice;

    @Column(name = "GINDStatus", length = 50)
    private String gINDStatus;

    @Column(name = "Note")
    private String note;

}