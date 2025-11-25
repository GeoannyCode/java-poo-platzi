package platzi.play;

import platzi.play.content.*;
import platzi.play.platform.*;
import platzi.play.util.ScannerUtils;

public class Main {
    public static final String NAME_PLATFORM = "PLATZI PLAY";
    public static final String VERSION = "1.0.0";


    public static final int ADD_CONTENT = 1;
    public static final int SHOW_ALL = 2;
    public static final int SEARCH_BY_TITLE = 3;
    public static final int DELETE = 4;
    public static final int EXIT_VALUE = 5;

    public static void main(String[] args) {
        Platform platform = new Platform(NAME_PLATFORM);
        System.out.println(NAME_PLATFORM + " v" + VERSION);

        while (true) {
            int selectedOption = ScannerUtils.inputNumber("""
            ****** MENU ******
            1. Add content
            2. Show all
            3. Search by title
            4. Delete
            5. Exit
            """);
            System.out.println("Chosen option: " + selectedOption);

            switch (selectedOption){
                case ADD_CONTENT -> {
                    String name = ScannerUtils.inputText("Content name");
                    String genre = ScannerUtils.inputText("Content genre");
                    int duration = ScannerUtils.inputNumber("Content duration");
                    double rating = ScannerUtils.inputDecimalValue("Content rating");

                    Movie movie = new Movie(name, duration, genre, rating);
                    platform.add(movie);
                }
                case SHOW_ALL -> {
                    platform.showTitles();
                }
                case SEARCH_BY_TITLE -> {
                    //TODO
                }
                case DELETE -> {
                    //TODO
                }
                case EXIT_VALUE -> {
                    System.exit(0);
                }
                default -> System.out.println("Option Error");
            }
        }


//        platform.add(movie);
//        platform.add(movie2);
//        System.out.println("number of items on the platform: " + platform.getContent().size());
//        platform.delete(movie2);
//
//        platform.showTitles();
//
//        User user = new User("Juan", "juan@platzi.com");
//        user.watching(movie);

    }
}
