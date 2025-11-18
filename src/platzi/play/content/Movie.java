package platzi.play.content;

import java.time.LocalDate;

public class Movie {

    // Attributes
    public String title;
    public String description;
    public int duration;
    public String genre;
    public LocalDate releaseDate;
    public double rating;
    public boolean available;

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

}

