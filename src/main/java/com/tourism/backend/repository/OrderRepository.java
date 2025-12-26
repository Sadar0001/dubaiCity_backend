package com.tourism.backend.repository;

import com.tourism.backend.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {
    // This magic method fetches all orders for a specific user ID
    List<Order> findByUserId(String userId);
}