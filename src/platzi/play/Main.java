package platzi.play;

import platzi.play.content.*;
import platzi.play.platform.User;
import platzi.play.util.ScannerUtils;

import javax.swing.text.AbstractDocument;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static final String VERSION = "1.0.0";

    public static void main(String[] args) {
        System.out.println(" **** PLATZI PLAY **** v" + VERSION);

        String name = ScannerUtils.inputText("Content name");
        String genre = ScannerUtils.inputText("Content genre");
        int duration = ScannerUtils.inputNumber("Content duration");
        double rating = ScannerUtils.inputDecimalValue("Content rating");

        // Instantiate an object
        Movie movie = new Movie();

        movie.title = name;
        movie.releaseDate = LocalDate.of(2015,10,2);
        movie.genre = genre;
        movie.rate(rating);
        movie.duration = duration;

        System.out.println(movie.getTechnicalSheet());

        User user = new User();
        user.name = "Don Juan";
        user.registrationDate = LocalDateTime.of(2025,12,24,17,15,14);

        user.watching(movie);

    }
}
