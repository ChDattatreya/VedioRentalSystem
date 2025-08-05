package videostore;

public class Video {
    private String title;
    private boolean checkedOut;
    private double averageRating;
    private double totalRatings;
    private int ratingCount;
    
    public Video(String title) {
        this.title = title;
        this.checkedOut = false;
        this.averageRating = 0.0;
        this.totalRatings = 0;
        this.ratingCount = 0;
    }
    
    // Checkout video
    public void checkOut() {
        this.checkedOut = true;
        System.out.println(title + " has been checked out.");
    }
    
    // Return video
    public void returnVideo() {
        this.checkedOut = false;
        System.out.println(title + " has been returned.");
    }
    
    // Receive rating (1-5 scale)
    public void receiveRating(double rating) {
        if (rating >= 0.0 && rating <= 5.0) {
            totalRatings += rating;
            ratingCount++;
            averageRating = (double) totalRatings / ratingCount;
            System.out.println("Rating received for " + title);
        }
    }
    
    // Getters
    public String getTitle() { return title; }
    public boolean isCheckedOut() { return checkedOut; }
    public double getAverageRating() { return averageRating; }
    
    @Override
    public String toString() {
        return String.format("%-25s | Rating: %.1f | %s", 
            title, averageRating, 
            checkedOut ? "Checked Out" : "Available");
    }
}

