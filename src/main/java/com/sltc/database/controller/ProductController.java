package com.sltc.database.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sltc.database.dto.ProductDto;
import com.sltc.database.entity.Product;
import com.sltc.database.service.ProductService;

@RestController
@CrossOrigin(origins = "*") // allowing cross origin to all
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());
    }

    @PostMapping("/products")
    public ResponseEntity<?> createProduct(@RequestBody ProductDto productDto) {

        try {
             return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(productDto));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to Create the Product");
        }
      
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product>  getProductById(@PathVariable Long id) {
        Product product = productService.geProductById(id);

        if(product !=null){
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/products/{id}")
    public Product updateproduct(@RequestBody Product product, @PathVariable Long id) {
        return productService.updateProduct(product, id);
    }
 
    @GetMapping("/categories/{id}/products")
    public ResponseEntity <List<Product>> getProductsByCtegory(@PathVariable Long id){
        return ResponseEntity.ok().body(productService.getProductsByCategory(id));
    }

}
