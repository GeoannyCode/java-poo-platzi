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

