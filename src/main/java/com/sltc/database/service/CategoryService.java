package com.sltc.database.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sltc.database.entity.Category;

@Service
public interface CategoryService {
    
    List<Category> getAllCategories();
    Category findCategoryById(Long id);
    Category creaCategory(Category category);
    Category updateCategory(Long id , Category category);

    
}
