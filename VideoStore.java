package videostore;

import java.util.ArrayList;
import java.util.List;

public class VideoStore {
    private List<Video> inventory;
    private String storeName;
    
    public VideoStore(String storeName) {
        this.storeName = storeName;
        this.inventory = new ArrayList<>();
    }
    
    // Add video to inventory
    public void addVideo(String title) {
        Video newVideo = new Video(title);
        inventory.add(newVideo);
        System.out.println("Added: " + title + " to inventory");
    }
    
    // Check out video by title
    public boolean checkOut(String title) {
        Video video = findVideo(title);
        if (video != null && !video.isCheckedOut()) {
            video.checkOut();
            return true;
        } else if (video != null && video.isCheckedOut()) {
            System.out.println(title + " is already checked out.");
        } else {
            System.out.println(title + " not found in inventory.");
        }
        return false;
    }
    
    // Return video by title
    public boolean returnVideo(String title) {
        Video video = findVideo(title);
        if (video != null && video.isCheckedOut()) {
            video.returnVideo();
            return true;
        } else if (video != null && !video.isCheckedOut()) {
            System.out.println(title + " is not currently checked out.");
        } else {
            System.out.println(title + " not found in inventory.");
        }
        return false;
    }
    
    // Rate a video
    public void receiveRating(String title, double rating) {
        Video video = findVideo(title);
        if (video != null) {
            video.receiveRating(rating);
        } else {
            System.out.println(title + " not found in inventory.");
        }
    }
    
    // List all inventory
    public void listInventory() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("           " + storeName + " - Video Inventory");
        System.out.println("=".repeat(60));
        if (inventory.isEmpty()) {
            System.out.println("No videos in inventory.");
        } else {
            for (Video video : inventory) {
                System.out.println(video);
            }
        }
        System.out.println("=".repeat(60));
    }
    
    // Helper method to find video by title
    private Video findVideo(String title) {
        for (Video video : inventory) {
            if (video.getTitle().equalsIgnoreCase(title)) {
                return video;
            }
        }
        return null;
    }
    
    // Get inventory size
    public int getInventorySize() {
        return inventory.size();
    }
}
