package com.example.vinasoy.repository.sales;

import com.example.vinasoy.entity.sales.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, String> {
    @Query(value = "SELECT c.CustomerID FROM Customer c ORDER BY c.CustomerID DESC LIMIT 1", nativeQuery = true)
    String findMaxCustomerCode();

    @Query(value = "SELECT COUNT(*) > 0 FROM Customer WHERE phone = :phone OR email = :email", nativeQuery = true)
    boolean existsByPhoneOrEmail(@Param("phone") String phone, @Param("email") String email);
}
