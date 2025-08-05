package videostore;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String customerId;
    private List<String> rentedVideos;
    private int maxRentals;
    
    public Customer(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
        this.rentedVideos = new ArrayList<>();
        this.maxRentals = 3; // Maximum 3 videos at once
    }
    
    public boolean canRent() {
        return rentedVideos.size() < maxRentals;
    }
    
    public void addRental(String videoTitle) {
        if (canRent()) {
            rentedVideos.add(videoTitle);
        }
    }
    
    public void removeRental(String videoTitle) {
        rentedVideos.remove(videoTitle);
    }
    
    // Getters
    public String getName() { return name; }
    public String getCustomerId() { return customerId; }
    public List<String> getRentedVideos() { return new ArrayList<>(rentedVideos); }
    public int getRentalCount() { return rentedVideos.size(); }
}

