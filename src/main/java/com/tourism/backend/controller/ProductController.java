package com.tourism.backend.controller;

import com.tourism.backend.model.Product;
import com.tourism.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*") // Allow React/Next.js to access this
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // 1. Get All Products
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // 2. Get Single Product by ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id) {
        return productRepository.findById(id).orElse(null);
    }

    // 3. Filter by Category (e.g., /api/products/search?category=Camping)
    @GetMapping("/search")
    public List<Product> getProductsByCategory(@RequestParam String category) {
        return productRepository.findByCategoriesContainingIgnoreCase(category);
    }
}