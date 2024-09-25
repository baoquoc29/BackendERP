package com.example.vinasoy.entity.sales;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "CustomerID", nullable = false, length = 10)
    private String customerID;

    @Column(name = "FullName", length = 50)
    private String fullName;

    @Column(name = "Email", length = 100)
    private String email;

    @Column(name = "PhoneNumber", length = 20)
    private String phoneNumber;

    @Lob
    @Column(name = "Address")
    private String address;

}