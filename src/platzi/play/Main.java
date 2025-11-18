package platzi.play;

import platzi.play.content.*;
import platzi.play.platform.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println(" **** PLATZI PLAY **** ");

        // Instantiate an object
        Movie movie = new Movie();

        movie.title = "Ready Player One";
        movie.releaseDate = LocalDate.of(2015,10,2);
        movie.genre = "Science Fiction";
        movie.rate(7.5);
        movie.duration = 120;

        long durationlong = movie.duration;
        int rateInt = (int) movie.rating;
        int prizeCount = (int) Long.parseLong("5");

        System.out.println("Duration Long: " + durationlong);
        System.out.println("Rating Int: " + rateInt);
        System.out.println("Price Count: " + prizeCount);


        System.out.println(movie.getTechnicalSheet());

        User user = new User();
        user.name = "Don Juan";
        user.registrationDate = LocalDateTime.of(2025,12,24,17,15,14);

        System.out.println(user.registrationDate);
        user.watching(movie);

    }
}
