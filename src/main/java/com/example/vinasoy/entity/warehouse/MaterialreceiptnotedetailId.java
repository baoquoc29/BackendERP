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
public class MaterialreceiptnotedetailId implements java.io.Serializable {
    private static final long serialVersionUID = -2464327470459650897L;
    @Size(max = 10)
    @NotNull
    @Column(name = "MaterialID", nullable = false, length = 10)
    private String materialID;

    @Size(max = 10)
    @NotNull
    @Column(name = "MaterialReceiptNoteID", nullable = false, length = 10)
    private String materialReceiptNoteID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MaterialreceiptnotedetailId entity = (MaterialreceiptnotedetailId) o;
        return Objects.equals(this.materialReceiptNoteID, entity.materialReceiptNoteID) &&
                Objects.equals(this.materialID, entity.materialID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(materialReceiptNoteID, materialID);
    }

}