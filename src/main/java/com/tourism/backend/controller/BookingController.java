package com.tourism.backend.controller;

import com.tourism.backend.model.Order;
import com.tourism.backend.model.Product;
import com.tourism.backend.repository.OrderRepository;
import com.tourism.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*")
public class BookingController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    // 1. Purchase a Product
    @PostMapping("/purchase")
    public Object purchaseProduct(@RequestBody Map<String, String> payload) {
        String userId = payload.get("userId");
        String productId = payload.get("productId");

        // Validate Product exists
        Product product = productRepository.findById(productId).orElse(null);
        if (product == null) {
            return "Error: Product not found";
        }

        // Create Order Object
        Order newOrder = new Order();
        newOrder.setUserId(userId);
        newOrder.setProductId(productId);
        newOrder.setProductTitle(product.getTitle()); // Save snapshot of title
        newOrder.setAmount(product.getPricing().getCurrentPrice());
        newOrder.setStatus("CONFIRMED");
        newOrder.setBookingDate(LocalDateTime.now());

        // Save to MongoDB
        return orderRepository.save(newOrder);
    }

    // 2. Get User History
    @GetMapping("/history/{userId}")
    public List<Order> getUserHistory(@PathVariable String userId) {
        return orderRepository.findByUserId(userId);
    }
}