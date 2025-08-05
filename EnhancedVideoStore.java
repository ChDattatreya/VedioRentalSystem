package videostore;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class EnhancedVideoStore extends VideoStore {
    private Map<String, Customer> customers;
    
    public EnhancedVideoStore(String storeName) {
        super(storeName);
        this.customers = new HashMap<>();
    }
    
    // Register new customer
    public void registerCustomer(String name, String customerId) {
        if (!customers.containsKey(customerId)) {
            customers.put(customerId, new Customer(name, customerId));
            System.out.println("Customer registered: " + name);
        } else {
            System.out.println("Customer ID already exists.");
        }
    }
    
    // Enhanced checkout with customer tracking
    public boolean checkOutToCustomer(String title, String customerId) {
        Customer customer = customers.get(customerId);
        if (customer == null) {
            System.out.println("Customer not found. Please register first.");
            return false;
        }
        
        if (!customer.canRent()) {
            System.out.println("Customer has reached maximum rental limit.");
            return false;
        }
        
        if (checkOut(title)) {
            customer.addRental(title);
            System.out.println(title + " rented to " + customer.getName());
            return true;
        }
        return false;
    }
    
    // Enhanced return with customer tracking
    public boolean returnFromCustomer(String title, String customerId) {
        Customer customer = customers.get(customerId);
        if (customer == null) {
            System.out.println("Customer not found.");
            return false;
        }
        
        if (returnVideo(title)) {
            customer.removeRental(title);
            System.out.println(title + " returned by " + customer.getName());
            return true;
        }
        return false;
    }
    
    // Display customer rentals
    public void displayCustomerRentals(String customerId) {
        Customer customer = customers.get(customerId);
        if (customer != null) {
            System.out.println("\nRentals for " + customer.getName() + ":");
            List<String> rentals = customer.getRentedVideos();
            if (rentals.isEmpty()) {
                System.out.println("No current rentals.");
            } else {
                for (String video : rentals) {
                    System.out.println("- " + video);
                }
            }
        }
    }
}

