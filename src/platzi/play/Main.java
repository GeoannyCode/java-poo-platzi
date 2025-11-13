package platzi.play;

import platzi.play.content.*;
import platzi.play.platform.User;

public class Main {
    public static void main(String[] args) {
        System.out.println(" **** PLATZI PLAY **** ");

        // Instantiate an object
        Movie movie = new Movie();

        movie.title = "Ready Player One";
        movie.releaseYear = 2018;
        movie.genre = "Science Fiction";
        movie.rate(7.5);

        User user = new User();
        user.name = "Don Juan";

        user.watching(movie);

    }
}
