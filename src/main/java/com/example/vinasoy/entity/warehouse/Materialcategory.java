package com.example.vinasoy.entity.warehouse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "materialcategory")
public class Materialcategory {
    @Id
    @Size(max = 10)
    @Column(name = "MaterialCategoryID", nullable = false, length = 10)
    private String materialCategoryID;

    @Size(max = 255)
    @Column(name = "MaterialCategoryName")
    private String materialCategoryName;

    @Size(max = 255)
    @Column(name = "Note")
    private String note;

}