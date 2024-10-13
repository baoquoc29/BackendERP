package com.example.vinasoy.entity.warehouse;

import com.example.vinasoy.entity.manufacture.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
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

    @MapsId("productID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ProductID", nullable = false)
    private Product productID;

    @MapsId("goodsReceiptNoteID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "GoodsReceiptNoteID", nullable = false)
    private Goodsreceiptnote goodsReceiptNoteID;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "DateOfManufacture")
    private LocalDate dateOfManufacture;

    @Size(max = 255)
    @Column(name = "Note")
    private String note;

}