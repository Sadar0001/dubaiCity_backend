package com.tourism.backend.repository;

import com.tourism.backend.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    // This enables: GET /api/products?category=wildlife
    List<Product> findByCategoriesContainingIgnoreCase(String category);

    // This enables: GET /api/products?type=photoshoot
    List<Product> findByType(String type);
}