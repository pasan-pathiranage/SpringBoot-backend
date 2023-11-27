package com.sltc.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sltc.database.dto.ProductDto;
import com.sltc.database.entity.Category;
import com.sltc.database.entity.Product;
import com.sltc.database.repository.CategoryRepository;
import com.sltc.database.repository.PrductRepository;

@Service
public class ProdecuServiceImpl implements ProductService {
    @Autowired
    private PrductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(ProductDto productDto) {
        Category category = categoryRepository.findById(productDto.getCategoryId()).orElse(null);
        if(category != null){
            Product product = new Product();
            product.setName(productDto.getName());
            product.setPrice(productDto.getPrice());
            product.setQty(productDto.getQty());
            product.setCategory(category);


            return productRepository.save(product);
        }else{
            return null;
        }
        

    }

    @Override
    public Product geProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product updateProduct(Product product, Long id) {
        Product existingProduct = productRepository.findById(id).orElse(null);

        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setCategory(product.getCategory());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setQty(product.getQty());
            return productRepository.save(existingProduct);
        } else {
            return null;
        }

    }

    @Override
    public  List<Product> getProductsByCategory(Long id){
        Category category = categoryRepository.findById(id).orElse(null);

        if(category != null){
            return productRepository.findProductsByCategory(category);
        }else{
            return null;
        }
    }
}
