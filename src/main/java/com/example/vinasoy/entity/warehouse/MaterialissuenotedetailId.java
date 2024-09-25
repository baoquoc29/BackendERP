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
public class MaterialissuenotedetailId implements java.io.Serializable {
    private static final long serialVersionUID = 49670021161007189L;
    @Column(name = "MaterialID", nullable = false, length = 10)
    private String materialID;

    @Column(name = "MaterialIssueNoteID", nullable = false, length = 10)
    private String materialIssueNoteID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MaterialissuenotedetailId entity = (MaterialissuenotedetailId) o;
        return Objects.equals(this.materialIssueNoteID, entity.materialIssueNoteID) &&
                Objects.equals(this.materialID, entity.materialID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(materialIssueNoteID, materialID);
    }

}