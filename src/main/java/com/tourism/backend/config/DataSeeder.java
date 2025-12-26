package com.tourism.backend.config;

import com.tourism.backend.model.Product;
import com.tourism.backend.model.User;
import com.tourism.backend.repository.ProductRepository;
import com.tourism.backend.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner initData(ProductRepository productRepo, UserRepository userRepo) {
        return args -> {
            // 1. Clean Database
            productRepo.deleteAll();
            userRepo.deleteAll();

            // --- CREATE USERS ---
            User user = new User();
            user.setEmail("sarah.travels@example.com");
            user.setName("Sarah Jenkins");
            user.setPassword("pass123");
            user.setRole("customer");
            userRepo.save(user);
            System.out.println("✅ Demo User Added");

            // --- CREATE 10 RICH CONTENT PRODUCTS ---

            List<Product> products = new ArrayList<>();

            // 1. Hatta Oman Border Trip (Your Specific Content)
            products.add(createRichProduct(
                    "Hatta Oman Border Trip 2026",
                    "hatta-oman-border-trip",
                    "adventure",
                    Arrays.asList("Adventure", "Mountains", "Sightseeing", "Nature"),
                    "Hatta", "Hatta Border Area",
                    150.00, 200.00, true,
                    "https://www.dubaicitytourism.com/wp-content/uploads/2025/12/hatta-dam-320x320.png",
                    // Overview
                    "A Hatta Oman border trip refreshes your Dubai routine, combining scenic roads, mountain air, and classic Hatta sightseeing. Dubai City Tourism plans this Hatta tour with a relaxed pace, photo stops, and a well-managed route overall.\n\nIf you’re comparing a Hatta tour from Dubai, Dubai City Tourism keeps it straightforward, comfortable, and complete for travelers. The drive follows the northern/eastern corridor linked to Dubai to Oman via Hatta, offering mountains and border-area scenery.",
                    // Highlights / Inclusions logic (mixed for display)
                    Arrays.asList(
                            "Ajman Museum: A peaceful cultural stop that gives the day a nice beginning.",
                            "Boma Fort: A small, old-style fort stop that fits well with the 'border route' feel.",
                            "Hatta Dam: This stop is all about open views and fresh air—your classic Hatta Dam visit moment.",
                            "Heritage Village: A heritage-focused stop that helps you understand Hatta beyond the viewpoints.",
                            "360 Observatory: A viewpoint-style stop designed for panoramic photos and 'wow' scenery.",
                            "Hills Park: A comfortable park stop with elevated views and easy walking areas.",
                            "Al Wadi Park & Leem Lake: Green, quiet, and perfect for families.",
                            "Wadi Hub: Adds a more lively, outdoor feel to the day."
                    ),
                    // Inclusions (Short list)
                    Arrays.asList("Hotel Pickup & Drop-off", "Professional Guide", "Water & Soft Drinks", "Museum Entry Fees"),
                    // Exclusions
                    Arrays.asList("Lunch (Optional)", "Personal Expenses", "Visa Fees (if crossing border)"),
                    // Cancellation Policy
                    "Free-Cancel Window: Cancellations made 24 hours or more before the scheduled pickup time are eligible for a full refund.\n\nLate Cancellation Refunds: Cancellations within 12–24 hours may be eligible for partial refunds.\n\nNon-Refundable Period: Cancellations made under 12 hours, or a no-show, are non-refundable.",
                    // Itinerary
                    Arrays.asList(
                            new Product.ItineraryItem(1, "Pickup and Departure", "Your day starts with pickup from your selected location. Dubai City Tourism keeps the process smooth so the trip begins calmly."),
                            new Product.ItineraryItem(2, "Drive Toward Border Corridor", "The journey feels like a real escape as city views fade and the landscape opens up—many guests enjoy this part because it feels like a true Hatta sightseeing tour."),
                            new Product.ItineraryItem(3, "Ajman Museum Stop", "You’ll begin with a cultural stop that adds context and a relaxed start to the day—simple, interesting, and easy for photos."),
                            new Product.ItineraryItem(4, "Boma Fort Visit", "Next is a quick fort-style heritage stop with a quiet atmosphere—ideal for unique pictures and a short walk."),
                            new Product.ItineraryItem(5, "Scenic Mountain Drive", "As the road climbs, the air feels cooler and the mountain scenery becomes the highlight."),
                            new Product.ItineraryItem(6, "Hatta Dam Experience", "Enjoy calm views, photo time, and a peaceful break that’s often a favorite moment of the day."),
                            new Product.ItineraryItem(7, "360 Observatory", "Expect panoramic scenery and some of the best landscape photo opportunities of the trip."),
                            new Product.ItineraryItem(8, "Wadi Hub & Return", "Finish with a relaxed nature stop and the activity-style environment at Wadi Hub, then begin the return journey.")
                    ),
                    // FAQs
                    Arrays.asList(
                            new Product.Faq("What should I wear?", "Wear comfortable shoes, carry sunglasses/sunscreen, and keep a light jacket—mountain weather can feel cooler."),
                            new Product.Faq("Do I need a passport?", "Bring your original passport if you intend to proceed with any border formalities."),
                            new Product.Faq("Is this a guided tour?", "Yes, this is a fully guided tour with a professional driver.")
                    )
            ));

            // 2. LEGOLAND Dubai (Rich Content)
            products.add(createRichProduct(
                    "LEGOLAND Dubai Theme Park Tickets",
                    "legoland-dubai-tickets",
                    "theme-park",
                    Arrays.asList("Theme Parks", "Family Friendly", "Dubai Parks"),
                    "Dubai", "Dubai Parks and Resorts",
                    295.00, 330.00, true,
                    "https://www.dubaicitytourism.com/wp-content/uploads/2025/10/Yas-Island-Multi-Park-Tickets-320x320.webp",
                    "Buy and book your LEGOLAND Dubai theme park tickets online with Dubai City Tourism at the cheapest prices. Located inside Dubai Parks and Resorts, LEGOLAND Dubai is one of the top 10 theme parks in Dubai, offering more than 40 LEGO-themed rides, shows, and attractions designed for kids and families.\n\nYour LEGOLAND Dubai tickets include access to exciting zones such as LEGO City, Kingdoms, Adventure, Miniland, and Imagination.",
                    Arrays.asList(
                            "Full-day access to LEGOLAND Dubai Theme Park.",
                            "Unlimited entry to 40+ LEGO-themed rides, shows, and attractions.",
                            "Access to child-friendly rides and family attractions.",
                            "Visit Miniland Dubai, showcasing 15,000+ LEGO models."
                    ),
                    Arrays.asList("Entry Ticket", "Unlimited Rides", "Free Parking"),
                    Arrays.asList("Food & Drinks", "QFast Pass", "Valet Parking"),
                    "Standard Tickets: Non-refundable and non-transferable once booked.\nDate Changes: Rescheduling may be possible 48 hours in advance.",
                    Arrays.asList(
                            new Product.ItineraryItem(1, "Arrival & Entry", "Reach LEGOLAND Dubai via Sheikh Zayed Road. Scan tickets for entry."),
                            new Product.ItineraryItem(2, "LEGO City", "Start here where kids can get their driving license."),
                            new Product.ItineraryItem(3, "Kingdoms & Adventure", "Ride the Dragon Coaster and explore the Pharaoh's revenge."),
                            new Product.ItineraryItem(4, "Miniland", "See the Burj Khalifa made entirely of LEGO."),
                            new Product.ItineraryItem(5, "Shopping & Departure", "Visit the Big Shop for souvenirs before leaving.")
                    ),
                    Arrays.asList(
                            new Product.Faq("What are the timings?", "10:00 AM to 6:00 PM on weekdays, extended on weekends."),
                            new Product.Faq("Is there a water park?", "Yes, LEGOLAND Water Park is next door (requires combo ticket).")
                    )
            ));

            // 3. Flying Dress Photoshoot (Rich Content)
            products.add(createRichProduct(
                    "Flying Dress Photoshoot Dubai | Premium Desert Shoot",
                    "flying-dress-photoshoot",
                    "photoshoot",
                    Arrays.asList("Photoshoot", "Luxury", "Couples", "Desert"),
                    "Dubai", "Red Sand Desert",
                    1200.00, 1500.00, false,
                    "https://www.dubaicitytourism.com/wp-content/uploads/2025/12/Untitled-design-19-320x320.png",
                    "Capture the memory of a lifetime with a professional Flying Dress Photoshoot in the stunning Dubai desert. Choose from our collection of glamorous, long-train satin dresses that flow in the wind against the golden dunes. Perfect for solo travelers, couples, and maternity shoots looking for that Instagram-perfect shot.",
                    Arrays.asList(
                            "Professional Photographer for 1 Hour.",
                            "Choice of Flying Dress (Red, Blue, Gold, etc.).",
                            "30 Edited High-Resolution Images.",
                            "Private Transfer to the shooting location."
                    ),
                    Arrays.asList("Dress Rental", "Photographer", "Transfer", "Water"),
                    Arrays.asList("Makeup & Hair", "Shoes", "Raw Images (Extra)"),
                    "Cancellations made 72 hours prior receive 100% refund. Within 72 hours, 50% refund.",
                    Arrays.asList(
                            new Product.ItineraryItem(1, "Pickup", "Luxury 4x4 pickup from your hotel."),
                            new Product.ItineraryItem(2, "Fitting", "Select your dress color and size. Our assistant helps you fit."),
                            new Product.ItineraryItem(3, "The Shoot", "1-hour session during Golden Hour for perfect lighting."),
                            new Product.ItineraryItem(4, "Review", "Quick review of shots on camera."),
                            new Product.ItineraryItem(5, "Return", "Drop-off at your hotel.")
                    ),
                    Arrays.asList(
                            new Product.Faq("Do sizes fit everyone?", "Our dresses are adjustable and fit sizes XS to XL."),
                            new Product.Faq("Can I bring my own prop?", "Yes, you can bring accessories like hats or sunglasses.")
                    )
            ));

            // 4. Overnight Desert Camping
            products.add(createRichProduct(
                    "Premium Overnight Desert Camping Experience",
                    "overnight-desert-camping",
                    "camping",
                    Arrays.asList("Camping", "Adventure", "Wildlife", "Nightlife"),
                    "Dubai", "Al Qudra Desert",
                    450.00, 600.00, true,
                    "https://www.dubaicitytourism.com/wp-content/uploads/2025/12/hatta-dam-320x320.png",
                    "Experience the true essence of Arabia with an overnight stay in the heart of the desert. Unlike standard safaris, this experience lets you sleep under a canopy of stars in a luxury Bedouin-style tent. Enjoy a BBQ dinner, traditional entertainment, and a sunrise camel trek.",
                    Arrays.asList(
                            "Dune Bashing: 45 minutes of adrenaline-pumping driving.",
                            "Camp Stay: Private tent with mattress, pillows, and blankets.",
                            "Entertainment: Belly dance, Tanura show, and Fire show.",
                            "Food: International BBQ Buffet Dinner and Morning Breakfast."
                    ),
                    Arrays.asList("Tent & Bedding", "Dinner & Breakfast", "Camel Ride", "Sandboarding"),
                    Arrays.asList("Alcohol", "Quad Bike (Extra)", "Private Photography"),
                    "Free cancellation up to 24 hours before the trip.",
                    Arrays.asList(
                            new Product.ItineraryItem(1, "Afternoon Pickup", "Pickup around 3:00 PM in a 4x4 Land Cruiser."),
                            new Product.ItineraryItem(2, "Safari", "Dune bashing and sunset photography stop."),
                            new Product.ItineraryItem(3, "Evening Camp", "Dinner, live shows, and shisha."),
                            new Product.ItineraryItem(4, "Overnight", "Sleep in secure tents under the stars."),
                            new Product.ItineraryItem(5, "Morning", "Sunrise camel trek, breakfast, and departure.")
                    ),
                    Arrays.asList(
                            new Product.Faq("Is there a bathroom?", "Yes, the camp has clean, separate restrooms."),
                            new Product.Faq("Is it safe?", "Yes, our camp is secured and fenced.")
                    )
            ));

            // 5. Dhow Cruise Marina
            products.add(createRichProduct(
                    "Luxury Dhow Cruise Marina with Dinner",
                    "dhow-cruise-marina",
                    "cruise",
                    Arrays.asList("Dining", "Cruise", "Couples", "Sightseeing"),
                    "Dubai", "Dubai Marina",
                    149.00, 200.00, true,
                    "https://www.dubaicitytourism.com/wp-content/uploads/2025/10/Dhow-Cruise-Marina-Dubai-320x320.webp",
                    "Set sail on a traditional wooden Dhow boat through the ultra-modern Dubai Marina. Gaze at the illuminated skyline of JBR and the Marina while enjoying a delicious 5-star international buffet dinner accompanied by soft background music and a Tanura dance show.",
                    Arrays.asList(
                            "2-Hour Cruise along Dubai Marina.",
                            "International Buffet Dinner (Veg & Non-Veg).",
                            "Tanura Dance Entertainment.",
                            "Open Air Upper Deck."
                    ),
                    Arrays.asList("Buffet Dinner", "Welcome Drinks", "Cruise Access"),
                    Arrays.asList("Alcohol", "Transfers (unless selected)"),
                    "Refundable if cancelled 24 hours in advance.",
                    Arrays.asList(
                            new Product.ItineraryItem(1, "Boarding", "Arrive at 8:00 PM for boarding."),
                            new Product.ItineraryItem(2, "Cruise Start", "Depart at 8:30 PM towards JBR."),
                            new Product.ItineraryItem(3, "Dinner", "Buffet opens immediately."),
                            new Product.ItineraryItem(4, "Entertainment", "Live Tanura show."),
                            new Product.ItineraryItem(5, "Docking", "Return to pier at 10:30 PM.")
                    ),
                    Arrays.asList(
                            new Product.Faq("Is there a dress code?", "Smart casual is recommended."),
                            new Product.Faq("Is it wheelchair accessible?", "Yes, the lower deck is accessible.")
                    )
            ));

            // 6. Burj Khalifa
            products.add(createRichProduct(
                    "Burj Khalifa At The Top - Level 124 & 125",
                    "burj-khalifa-tickets",
                    "sightseeing",
                    Arrays.asList("Sightseeing", "Iconic", "Views"),
                    "Dubai", "Downtown Dubai",
                    179.00, 179.00, false,
                    "https://www.dubaicitytourism.com/wp-content/uploads/2025/04/Dubai-1-736x1024.jpg",
                    "No trip to Dubai is complete without visiting the world's tallest building. Board the world's fastest elevator to the observation decks on levels 124 and 125. Enjoy 360-degree panoramic views of the city, desert, and ocean.",
                    Arrays.asList(
                            "Access to Level 124 & 125.",
                            "World's fastest double-deck elevators.",
                            "Use of high-powered telescopes.",
                            "Outdoor observation terrace."
                    ),
                    Arrays.asList("Entry Ticket", "Wi-Fi"),
                    Arrays.asList("Skip-the-line", "Food & Beverages"),
                    "Non-refundable once booked. Time slots are strict.",
                    Arrays.asList(
                            new Product.ItineraryItem(1, "Entry", "Enter via Dubai Mall Lower Ground Floor."),
                            new Product.ItineraryItem(2, "Elevator", "Ascend 124 floors in 60 seconds."),
                            new Product.ItineraryItem(3, "Observation", "Enjoy the views and take photos."),
                            new Product.ItineraryItem(4, "Exit", "Browse the souvenir shop on the way out.")
                    ),
                    Arrays.asList(
                            new Product.Faq("Best time to visit?", "Sunset slots (4-6 PM) are most popular."),
                            new Product.Faq("Are tickets timed?", "Yes, you must enter at your specific time.")
                    )
            ));

            // 7. Museum of the Future
            products.add(createRichProduct(
                    "Museum of the Future Entry Ticket",
                    "museum-of-future",
                    "culture",
                    Arrays.asList("Culture", "Technology", "Indoor"),
                    "Dubai", "Sheikh Zayed Road",
                    149.00, 149.00, false,
                    "https://www.dubaicitytourism.com/wp-content/uploads/2025/01/Dubai-Tours-Hero-Banner-DCT-Dubai-City-Tourism.jpg",
                    "Journey to the year 2071. The Museum of the Future is an architectural marvel and immersive exhibition exploring the future of space travel, climate change, and health. It is one of the most beautiful buildings on earth.",
                    Arrays.asList(
                            "OSS Hope: Space station simulation.",
                            "The Heal Institute: Digital Amazon rainforest.",
                            "Tomorrow Today: Future technology exhibition."
                    ),
                    Arrays.asList("Entry Ticket", "Digital Guide"),
                    Arrays.asList("Food", "Valet Parking"),
                    "Non-refundable. Tickets sell out weeks in advance.",
                    Arrays.asList(
                            new Product.ItineraryItem(1, "Entry", "Scan ticket at the lobby."),
                            new Product.ItineraryItem(2, "Journey", "Take the elevator to 2071."),
                            new Product.ItineraryItem(3, "Explore", "Walk down through the exhibition floors."),
                            new Product.ItineraryItem(4, "Viewing Deck", "Visit the outdoor deck for photos.")
                    ),
                    Arrays.asList(
                            new Product.Faq("Can I bring a bag?", "Large bags must be stored in lockers."),
                            new Product.Faq("Is it kid friendly?", "Yes, there is a dedicated 'Future Heroes' floor.")
                    )
            ));

            // 8. Jet Ski
            products.add(createRichProduct(
                    "30-Minute Jet Ski Tour - Burj Al Arab View",
                    "jet-ski-dubai",
                    "water-sports",
                    Arrays.asList("Water Sports", "Adventure", "Thrill"),
                    "Dubai", "Jumeirah Beach",
                    350.00, 400.00, true,
                    "https://www.dubaicitytourism.com/wp-content/uploads/2025/12/Untitled-design-19-2-320x320.png",
                    "Feel the adrenaline rush as you speed across the Persian Gulf on a high-power Jet Ski. This guided tour takes you close to the iconic Burj Al Arab for the ultimate photo opportunity from the water.",
                    Arrays.asList(
                            "High-Speed Fun on Yamaha Jet Skis.",
                            "Iconic Views of Burj Al Arab.",
                            "Safety briefing and life jackets included."
                    ),
                    Arrays.asList("Jet Ski Rental", "Life Jacket", "Water"),
                    Arrays.asList("Towels", "Swimwear"),
                    "Cancel 24 hours ahead for full refund.",
                    Arrays.asList(
                            new Product.ItineraryItem(1, "Briefing", "Meet instructor and get safety gear."),
                            new Product.ItineraryItem(2, "Ride", "Follow the guide into the open sea."),
                            new Product.ItineraryItem(3, "Photo Stop", "Pause at Burj Al Arab for photos."),
                            new Product.ItineraryItem(4, "Return", "Ride back to the marina.")
                    ),
                    Arrays.asList(
                            new Product.Faq("Do I need a license?", "No, just a valid ID."),
                            new Product.Faq("Can we ride double?", "Yes, up to 2 people per ski.")
                    )
            ));

            // 9. Atlantis Aquaventure
            products.add(createRichProduct(
                    "Atlantis Aquaventure Waterpark Day Pass",
                    "atlantis-aquaventure",
                    "theme-park",
                    Arrays.asList("Theme Parks", "Water Sports", "Family Friendly"),
                    "Dubai", "Atlantis The Palm",
                    345.00, 395.00, true,
                    "https://www.dubaicitytourism.com/wp-content/uploads/2025/12/fujairah-1-320x320.png",
                    "Splash into a world of excitement at the world's largest waterpark. Aquaventure features 105 record-breaking slides, attractions, and experiences, including the Leap of Faith and a private beach.",
                    Arrays.asList("Unlimited access to all 105 slides.", "Access to the private beach.", "Surf's Up wave rider."),
                    Arrays.asList("Day Pass", "Socks (Free)"),
                    Arrays.asList("Towels", "Lockers", "Food"),
                    "Non-refundable. Valid only for selected date.",
                    Arrays.asList(
                            new Product.ItineraryItem(1, "Arrival", "Go to Ticketing Plaza."),
                            new Product.ItineraryItem(2, "Action", "Hit the Trident Tower slides first."),
                            new Product.ItineraryItem(3, "Relax", "Float on the lazy river."),
                            new Product.ItineraryItem(4, "Beach", "Unwind on the private beach.")
                    ),
                    Arrays.asList(
                            new Product.Faq("Are towels free?", "No, you must rent them."),
                            new Product.Faq("Is food allowed?", "No outside food allowed.")
                    )
            ));

            // 10. Jebel Jais Zipline
            products.add(createRichProduct(
                    "Jebel Jais Flight - World's Longest Zipline",
                    "jebel-jais-zipline",
                    "adventure",
                    Arrays.asList("Adventure", "Mountains", "Thrill"),
                    "Ras Al Khaimah", "Jebel Jais Mountain",
                    450.00, 500.00, true,
                    "https://www.dubaicitytourism.com/wp-content/uploads/2025/12/jebel-jais-1-320x320.png",
                    "Push your limits on the Jebel Jais Flight, the Guinness World Record holder for the longest zipline. Soar across jagged mountain peaks at speeds of up to 150 kmph.",
                    Arrays.asList(
                            "World Record: 2.83km long flight.",
                            "Speed: Reach up to 150 kmph.",
                            "Views: Unbeatable views of the Hajar Mountains."
                    ),
                    Arrays.asList("Zipline Flight", "Safety Gear", "Certificate"),
                    Arrays.asList("Transport", "Food", "Video"),
                    "Strict cancellation policy. No refunds within 3 days.",
                    Arrays.asList(
                            new Product.ItineraryItem(1, "Check-in", "Arrive at the Welcome Center."),
                            new Product.ItineraryItem(2, "Shuttle", "Ride to the launch platform."),
                            new Product.ItineraryItem(3, "Flight", "2-3 minutes of pure adrenaline."),
                            new Product.ItineraryItem(4, "Landing", "Land on the suspended platform.")
                    ),
                    Arrays.asList(
                            new Product.Faq("Weight limits?", "Min 40kg, Max 120kg."),
                            new Product.Faq("Is transport included?", "No, you must drive there.")
                    )
            ));

            productRepo.saveAll(products);
            System.out.println("✅ 10 Rich-Content Products Added to MongoDB Cloud");
        };
    }

    // --- HELPER METHOD ---
    private Product createRichProduct(
            String title, String slug, String type, List<String> categories,
            String city, String locName, Double price, Double origPrice,
            boolean sale, String imgUrl, String overview,
            List<String> highlights, List<String> inclusions, List<String> exclusions,
            String cancellationPolicy, List<Product.ItineraryItem> itinerary, List<Product.Faq> faqs) {

        Product p = new Product();
        p.setTitle(title);
        p.setSlug(slug);
        p.setType(type);
        p.setStatus("active");
        p.setCategories(categories);
        p.setOverview(overview);
        p.setHighlights(highlights);

        Product.Destination d = new Product.Destination();
        d.setCity(city);
        d.setCountry("United Arab Emirates");
        d.setLocationName(locName);
        p.setDestination(d);

        Product.Pricing pr = new Product.Pricing();
        pr.setCurrency("AED");
        pr.setCurrentPrice(price);
        pr.setOriginalPrice(origPrice);
        pr.setOnSale(sale);
        p.setPricing(pr);

        Product.Image img = new Product.Image();
        img.setUrl(imgUrl);
        img.setFeatured(true);
        img.setAlt(title);
        p.setImages(Arrays.asList(img));

        Product.Details det = new Product.Details();
        det.setInclusions(inclusions);
        det.setExclusions(exclusions);
        det.setCancellationPolicy(cancellationPolicy);

        Product.Timings t = new Product.Timings();
        t.setWeekdays("10:00 AM - 6:00 PM");
        t.setWeekends("10:00 AM - 8:00 PM");
        det.setTimings(t);
        p.setDetails(det);

        p.setItinerary(itinerary);
        p.setFaqs(faqs);

        // Dummy rating
        Product.Rating r = new Product.Rating();
        r.setAverageScore(4.5);
        r.setReviewCount(100 + (int)(Math.random() * 50));
        p.setRating(r);

        return p;
    }
}