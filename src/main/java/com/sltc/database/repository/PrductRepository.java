package com.sltc.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sltc.database.entity.Category;
import com.sltc.database.entity.Product;

@Repository
public interface PrductRepository extends JpaRepository<Product, Long>{
    // Custom Query ti get products by category

    @Query("SELECT p FROM Product p WHERE p.category = :category")
    List<Product> findProductsByCategory(@Param("category") Category category);
}
 