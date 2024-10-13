package com.example.vinasoy.entity.sales;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(
            mappedBy = "customer",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )

    @JsonManagedReference
    private Set<Order> orders = new HashSet<>();


    public void addOrder(Order order) {
        if(order != null) {
            orders.add(order);
            order.setCustomer(this);
        }
    }

    public void removeOrder(Order order) {
        if(order != null) {
            orders.remove(order);
            order.setCustomer(null);
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID='" + customerID + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}