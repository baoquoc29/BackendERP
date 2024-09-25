package com.example.vinasoy.entity.warehouse;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class GoodsreceiptnotedetailId implements java.io.Serializable {
    private static final long serialVersionUID = 4004032526623967853L;
    @Column(name = "ProductID", nullable = false, length = 10)
    private String productID;

    @Column(name = "GoodsReceiptNoteID", nullable = false, length = 10)
    private String goodsReceiptNoteID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        GoodsreceiptnotedetailId entity = (GoodsreceiptnotedetailId) o;
        return Objects.equals(this.goodsReceiptNoteID, entity.goodsReceiptNoteID) &&
                Objects.equals(this.productID, entity.productID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsReceiptNoteID, productID);
    }

}