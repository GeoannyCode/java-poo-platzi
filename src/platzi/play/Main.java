package platzi.play;

import platzi.play.content.*;
import platzi.play.platform.*;
import platzi.play.util.ScannerUtils;

public class Main {
    public static final String NAME_PLATFORM = "PLATZI PLAY";
    public static final String VERSION = "1.0.0";

    public static void main(String[] args) {
        Platform platform = new Platform(NAME_PLATFORM);

        String name = ScannerUtils.inputText("Content name");
        String genre = ScannerUtils.inputText("Content genre");
        int duration = ScannerUtils.inputNumber("Content duration");
        double rating = ScannerUtils.inputDecimalValue("Content rating");

        // Instantiate an object
        Movie movie = new Movie(name, duration, genre, rating);
        Movie movie2 = new Movie("Lego Movie", 130, "Animation", 8.7);

        platform.add(movie);
        platform.add(movie2);
        System.out.println("number of items on the platform: " + platform.getContent().size());
        platform.delete(movie2);

        platform.showTitles();

        User user = new User("Juan", "juan@platzi.com");
        user.watching(movie);

    }
}
