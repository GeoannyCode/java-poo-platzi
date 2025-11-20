package platzi.play;

import platzi.play.content.*;
import platzi.play.platform.User;
import platzi.play.util.ScannerUtils;

public class Main {
    public static final String VERSION = "1.0.0";

    public static void main(String[] args) {
        System.out.println(" **** PLATZI PLAY **** v" + VERSION);

        String name = ScannerUtils.inputText("Content name");
        String genre = ScannerUtils.inputText("Content genre");
        int duration = ScannerUtils.inputNumber("Content duration");
        double rating = ScannerUtils.inputDecimalValue("Content rating");

        // Instantiate an object
        Movie movie = new Movie(name, duration, genre, rating);

        movie.setAvailable(false);

        System.out.println(movie.getTechnicalSheet());

        User user = new User("Juan", "juan@platzi.com");

        user.watching(movie);

    }
}
