package platzi.play.content;

import java.time.LocalDate;

public class Movie {

    // Attributes
    private String title;
    private String description;
    private int duration;
    private String genre;
    private LocalDate releaseDate;
    private double rating;
    private boolean available;

    public Movie(String title, int duration, String genre){
        this.title = title;
        this.duration = duration;
        this.genre = genre;
        this.releaseDate = LocalDate.now();
        this.available = true;
    }

    public Movie(String title, int duration, String genre, double rating) {
        this(title, duration, genre);
        this.rate(rating);
    }

    // Methods
    public void play(){
        System.out.println(title);
    }

    public String getTechnicalSheet(){
        return title + " (" + releaseDate.getYear() + ")\n" +
                "Genre: " + genre + "\n" +
                "Rating: " + rating + "/10";
    }

    public void rate(double rating){
        if (rating >= 0 && rating <= 10){
            this.rating = rating;
        }
    }

    public boolean isPopular(){
        return rating >= 8;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public double getRating() {
        return rating;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

