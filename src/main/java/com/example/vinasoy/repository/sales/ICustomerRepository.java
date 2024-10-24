package com.example.vinasoy.repository.sales;

import com.example.vinasoy.entity.sales.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, String> {
    @Query(value = "SELECT c.CustomerID FROM Customer c ORDER BY c.CustomerID DESC LIMIT 1", nativeQuery = true)
    String findMaxCustomerCode();

    boolean existsByFullNameAndPhoneNumberAndEmail(String fullName, String phone, String email);

    Page<Customer> findAll(Specification<Customer> spec, Pageable pageable);

    @Query(value = "SELECT * FROM Customer " +
            "WHERE (:fullName IS NULL OR LOWER(unaccent(FullName)) LIKE LOWER(unaccent(CONCAT('%', :fullName, '%')))) " +
            "AND (:email IS NULL OR Email = :email) " +
            "AND (:phoneNumber IS NULL OR PhoneNumber = :phoneNumber) " +
            "AND (:address IS NULL OR LOWER(Address) LIKE LOWER(CONCAT('%', :address, '%')))",
            nativeQuery = true)
    List<Customer> searchCustomers(
            @Param("fullName") String fullName,
            @Param("email") String email,
            @Param("phoneNumber") String phoneNumber,
            @Param("address") String address
    );

    @Query(value = "SELECT * FROM Customer " +
            "WHERE (:fullName IS NULL OR LOWER(unaccent(FullName)) LIKE LOWER(unaccent(CONCAT('%', :fullName, '%')))) " +
            "AND (:email IS NULL OR Email = :email) " +
            "AND (:phoneNumber IS NULL OR PhoneNumber = :phoneNumber) " +
            "AND (:address IS NULL OR LOWER(Address) LIKE LOWER(CONCAT('%', :address, '%')))",
            nativeQuery = true)
    Page<Customer> searchCustomers(
            @Param("fullName") String fullName,
            @Param("email") String email,
            @Param("phoneNumber") String phoneNumber,
            @Param("address") String address,
            Pageable pageable
    );


}
