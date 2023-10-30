package com.project.capstone.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.capstone.entity.Product;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.features LIKE %:feature%")
    List<Product> findProductByFeature(@Param("feature") String feature);

    @Query("SELECT p FROM Product p WHERE p.parameters LIKE %:parameter%")
    List<Product> findProductByParameter(@Param("parameter") String parameter);
}
