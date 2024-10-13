package com.example.vinasoy.entity.employee;

import com.example.vinasoy.entity.sales.Goodsreceipt;
import com.example.vinasoy.entity.sales.Invoice;
import com.example.vinasoy.entity.sales.Order;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Size(max = 10)
    @Column(name = "EmployeeID", nullable = false, length = 10)
    private String employeeID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PositionID")
    private Position positionID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DepartmentID")
    private Department departmentID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ContractID")
    private Contract contractID;

    @Size(max = 255)
    @Column(name = "EmployeeName")
    private String employeeName;

    @Column(name = "Birthday")
    private LocalDate birthday;

    @Size(max = 10)
    @Column(name = "Gender", length = 10)
    private String gender;

    @Size(max = 15)
    @Column(name = "PhoneNumber", length = 15)
    private String phoneNumber;

    @Size(max = 255)
    @Column(name = "Email")
    private String email;

    @Size(max = 12)
    @Column(name = "CCCD", length = 12)
    private String cccd;

    @Size(max = 255)
    @Column(name = "Address")
    private String address;

    @Size(max = 50)
    @Column(name = "EmployeeStatus", length = 50)
    private String employeeStatus;


    @OneToMany(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )

    @JsonManagedReference
    private Set<Order> orders = new HashSet<>();


    public void addOrder(Order order) {
        if(order != null) {
            orders.add(order);
            order.setEmployee(this);
        }
    }

    public void removeOrder(Order order) {
        if(order != null) {
            orders.remove(order);
            order.setEmployee(null);
        }
    }

    @OneToMany(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )

    @JsonManagedReference
    private Set<Invoice> invoices = new HashSet<>();


    public void addInvoice(Invoice invoice) {
        if(invoice != null) {
            invoices.add(invoice);
            invoice.setEmployee(this);
        }
    }

    public void removeInvoice(Invoice invoice) {
        if(invoice != null) {
            invoices.remove(invoice);
            invoice.setEmployee(null);
        }
    }


    @OneToMany(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )

    @JsonManagedReference
    private Set<Goodsreceipt> goodsreceipts = new HashSet<>();


    public void addGoodsreceipts(Goodsreceipt goodsreceipt) {
        if(goodsreceipt != null) {
            goodsreceipts.add(goodsreceipt);
            goodsreceipt.setEmployee(this);
        }
    }

    public void removeGoodsreceipts(Goodsreceipt goodsreceipt) {
        if(goodsreceipt != null) {
            goodsreceipts.remove(goodsreceipt);
            goodsreceipt.setEmployee(null);
        }
    }



    @Override
    public String toString() {
        return "Employee{" +
                "employeeID='" + employeeID + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", cccd='" + cccd + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}