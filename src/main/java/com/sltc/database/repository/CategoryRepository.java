package com.sltc.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sltc.database.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>{
    
}
