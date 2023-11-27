package com.sltc.database.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sltc.database.dto.ProductDto;
import com.sltc.database.entity.Product;

@Service
public interface ProductService {

    List<Product> getAllProducts();
    Product createProduct(ProductDto productDto);
    Product geProductById(Long id);
    Product updateProduct(Product product, Long id);
    List<Product> getProductsByCategory(Long id);

}
