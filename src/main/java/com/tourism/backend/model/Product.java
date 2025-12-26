package com.tourism.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data
@Document(collection = "products")
public class Product {
    @Id
    private String id;

    private String title;
    private String slug;
    private String type; // e.g., "activity"
    private String status;

    private List<String> categories;
    private Destination destination;
    private Pricing pricing;
    private List<Image> images;
    private String overview;
    private List<String> highlights;
    private Details details;
    private List<ItineraryItem> itinerary;
    private List<Faq> faqs;
    private Rating rating;

    // --- Nested Static Classes for Structure ---

    @Data
    public static class Destination {
        private String city;
        private String country;
        private String locationName;
    }

    @Data
    public static class Pricing {
        private String currency;
        private Double currentPrice;
        private Double originalPrice;
        private boolean isOnSale;
        private List<TicketType> ticketTypes;
    }

    @Data
    public static class TicketType {
        private String name;
        private Double price;
    }

    @Data
    public static class Image {
        private String url;
        private boolean isFeatured;
        private String alt;
    }

    @Data
    public static class Details {
        private Timings timings;
        private String cancellationPolicy;
        private List<String> inclusions;
        private List<String> exclusions;
    }

    @Data
    public static class Timings {
        private String weekdays;
        private String weekends;
    }

    @Data
    @AllArgsConstructor // <--- REQUIRED for new ItineraryItem(1, "...", "...")
    @NoArgsConstructor  // <--- Good practice for MongoDB deserialization
    public static class ItineraryItem {
        private int stepNumber;
        private String title;
        private String description;
    }

    @Data
    @AllArgsConstructor // <--- REQUIRED for new Faq("...", "...")
    @NoArgsConstructor
    public static class Faq {
        private String question;
        private String answer;
    }

    @Data
    public static class Rating {
        private double averageScore;
        private int reviewCount;
    }
}