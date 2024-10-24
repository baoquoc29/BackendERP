package com.example.vinasoy.repository.warehouse;

import com.example.vinasoy.entity.warehouse.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IMaterialRepository extends JpaRepository<Material, String> {
    @Query(value = "select * from material where MaterialID = :id", nativeQuery = true)
    Material findOneById (@Param("id") String id);
}
