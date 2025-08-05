package videostore;

import java.util.Scanner;

public class VideoStoreLauncher {
    private static EnhancedVideoStore store;
    private static Scanner scanner;
    
    public static void main(String[] args) {
        store = new EnhancedVideoStore("MovieMania Video Store");
        scanner = new Scanner(System.in);
        
        // Initialize with sample data
        initializeSampleData();
        
        // Main menu loop
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getChoice();
            
            switch (choice) {
                case 1: addVideo(); break;
                case 2: registerCustomer(); break;
                case 3: checkOutVideo(); break;
                case 4: returnVideo(); break;
                case 5: rateVideo(); break;
                case 6: store.listInventory(); break;
                case 7: viewCustomerRentals(); break;
                case 0: running = false; break;
                default: System.out.println("Invalid choice!");
            }
        }
        
        System.out.println("Thank you for using VideoStore Management System!");
        scanner.close();
    }
    
    private static void initializeSampleData() {
        // Add sample videos
        store.addVideo("The Matrix");
        store.addVideo("Godfather II");
        store.addVideo("Star Wars Episode IV: A New Hope");
        store.addVideo("Inception");
        store.addVideo("The Dark Knight");
        
        // Register sample customers
        store.registerCustomer("John Doe", "CUST001");
        store.registerCustomer("Jane Smith", "CUST002");
        
        // Add some ratings
        store.receiveRating("The Matrix", 5);
        store.receiveRating("The Matrix", 4);
        store.receiveRating("Godfather II", 5);
        store.receiveRating("Inception", 4);
    }
    
    private static void displayMenu() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("    VIDEO STORE MANAGEMENT SYSTEM");
        System.out.println("=".repeat(40));
        System.out.println("1. Add Video");
        System.out.println("2. Register Customer");
        System.out.println("3. Check Out Video");
        System.out.println("4. Return Video");
        System.out.println("5. Rate Video");
        System.out.println("6. List Inventory");
        System.out.println("7. View Customer Rentals");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }
    
    private static int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    private static void addVideo() {
        System.out.print("Enter video title: ");
        String title = scanner.nextLine();
        store.addVideo(title);
    }
    
    private static void registerCustomer() {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter customer ID: ");
        String id = scanner.nextLine();
        store.registerCustomer(name, id);
    }
    
    private static void checkOutVideo() {
        System.out.print("Enter video title: ");
        String title = scanner.nextLine();
        System.out.print("Enter customer ID: ");
        String customerId = scanner.nextLine();
        store.checkOutToCustomer(title, customerId);
    }
    
    private static void returnVideo() {
        System.out.print("Enter video title: ");
        String title = scanner.nextLine();
        System.out.print("Enter customer ID: ");
        String customerId = scanner.nextLine();
        store.returnFromCustomer(title, customerId);
    }
    
    private static void rateVideo() {
        System.out.print("Enter video title: ");
        String title = scanner.nextLine();
        System.out.print("Enter rating (0.0-5.0): ");
        try {
            double rating = Double.parseDouble(scanner.nextLine());
            store.receiveRating(title, rating);
        } catch (NumberFormatException e) {
            System.out.println("Invalid rating. Please enter a number 1-5.");
        }
    }
    
    private static void viewCustomerRentals() {
        System.out.print("Enter customer ID: ");
        String customerId = scanner.nextLine();
        store.displayCustomerRentals(customerId);
    }
}

