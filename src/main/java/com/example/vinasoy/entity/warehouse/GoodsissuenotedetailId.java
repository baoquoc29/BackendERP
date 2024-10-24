package com.example.vinasoy.entity.warehouse;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class GoodsissuenotedetailId implements java.io.Serializable {
    private static final long serialVersionUID = -2468219953578937400L;
    @Size(max = 10)
    @NotNull
    @Column(name = "ProductID", nullable = false, length = 10)
    private String productID;

    @Size(max = 10)
    @NotNull
    @Column(name = "GoodsIssueNoteID", nullable = false, length = 10)
    private String goodsIssueNoteID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        GoodsissuenotedetailId entity = (GoodsissuenotedetailId) o;
        return Objects.equals(this.productID, entity.productID) &&
                Objects.equals(this.goodsIssueNoteID, entity.goodsIssueNoteID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID, goodsIssueNoteID);
    }

}