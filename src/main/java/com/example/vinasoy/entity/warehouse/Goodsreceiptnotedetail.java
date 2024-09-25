package com.example.vinasoy.entity.warehouse;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "goodsreceiptnotedetail")
public class Goodsreceiptnotedetail {
    @EmbeddedId
    private GoodsreceiptnotedetailId id;

    @MapsId("goodsReceiptNoteID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "GoodsReceiptNoteID", nullable = false)
    private Goodsreceiptnote goodsReceiptNoteID;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "DateOfManufacture")
    private LocalDate dateOfManufacture;

    @Column(name = "Note")
    private String note;

}