package platzi.play;

import platzi.play.content.Movie;

public class Main {
    public static void main(String[] args) {
        System.out.println(" **** PLATZI PLAY **** ");

        // Instantiate an object
        Movie movie = new Movie();

        movie.title = "Ready Player One";
        movie.releaseYear = 2018;
        movie.genre = "Science Fiction";
        movie.rate(7.5);

        System.out.println(movie.getTechnicalSheet());

    }
}
