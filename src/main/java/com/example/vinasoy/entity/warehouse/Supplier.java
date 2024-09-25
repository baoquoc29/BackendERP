package com.example.vinasoy.entity.warehouse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "supplier")
public class Supplier {
    @Id
    @Column(name = "SupplierID", nullable = false, length = 10)
    private String supplierID;

    @Column(name = "SupplierName")
    private String supplierName;

    @Column(name = "Address")
    private String address;

    @Column(name = "PhoneNumber", length = 20)
    private String phoneNumber;

    @Column(name = "Email")
    private String email;

}