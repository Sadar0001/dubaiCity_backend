package com.tourism.backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document(collection = "orders")
public class Order {
    @Id
    private String id;

    private String userId;      // Who bought it
    private String productId;   // What they bought
    private String productTitle; // Snapshot of title (in case it changes later)
    private Double amount;      // Price at time of purchase
    private String status;      // e.g., "CONFIRMED", "PENDING"
    private LocalDateTime bookingDate;
}