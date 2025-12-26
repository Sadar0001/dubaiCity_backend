package com.tourism.backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;

    @Indexed(unique = true) // Ensures no duplicate emails
    private String email;

    private String password; // Storing plain text as requested (Not secure for production!)
    private String name;
    private String role; // e.g., "customer", "admin"
}