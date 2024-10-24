package com.example.vinasoy.repository.sales;

import com.example.vinasoy.entity.sales.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, String> {
    @Query(value = "SELECT c.CustomerID FROM Customer c ORDER BY c.CustomerID DESC LIMIT 1", nativeQuery = true)
    String findMaxCustomerCode();

    boolean existsByFullNameAndPhoneNumberAndEmail(String fullName, String phone, String email);
}
