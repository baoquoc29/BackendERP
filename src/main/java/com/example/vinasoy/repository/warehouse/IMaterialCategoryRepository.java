package com.example.vinasoy.repository.warehouse;

import com.example.vinasoy.entity.warehouse.Materialcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IMaterialCategoryRepository extends JpaRepository<Materialcategory, String> {
    @Query(value = "select * from materialcategory where materialcategoryId = :id", nativeQuery = true)
    Materialcategory findOneById (@Param("id") String id);
}
