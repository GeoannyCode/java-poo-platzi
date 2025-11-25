package platzi.play;

import platzi.play.content.*;
import platzi.play.platform.*;
import platzi.play.util.ScannerUtils;

public class Main {
    public static final String NAME_PLATFORM = "PLATZI PLAY";
    public static final String VERSION = "1.0.0";

    private static final String MENU = """
                ************** MENU **************
                1. Add content
                2. Show all
                3. Search by title
                4. Delete
                5. Exit
                -----------------------------------
                Select an option:
                """;

    public static final int ADD_CONTENT = 1;
    public static final int SHOW_ALL = 2;
    public static final int SEARCH_BY_TITLE = 3;
    public static final int DELETE = 4;
    public static final int EXIT_VALUE = 5;

    public static void main(String[] args) {
        Platform platform = new Platform(NAME_PLATFORM);
        System.out.println(NAME_PLATFORM + " v" + VERSION);

        loadMovies(platform);

        while (true) {
            int selectedOption = ScannerUtils.inputNumber(MENU);

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
                    String inputName = ScannerUtils.inputText("Enter the name you want to search");
                    Movie movie = platform.searchByTitle(inputName);

                    if (movie != null){
                        System.out.println(movie.getTechnicalSheet());
                    }else {
                        System.out.println("Could not find \"" + inputName + "\" in " + platform.getName());
                    }
                }
                case DELETE -> {
                    String inputName = ScannerUtils.inputText("Enter the name you want to delete:");
                    Movie movie = platform.searchByTitle(inputName);

                    if (movie != null){
                        platform.delete(movie);
                        System.out.println("Deletion successful!");
                    }else {
                        System.out.println("Could not find \"" + inputName + "\" in " + platform.getName());
                    }
                }
                case EXIT_VALUE -> {
                    System.exit(0);
                }
                default -> System.out.println("Option Error");
            }
        }
    }

    private static void loadMovies(Platform platform){
        platform.add(new Movie("Shrek", 90, "Animated"));
        platform.add(new Movie("Inception", 148, "Science Fiction"));
        platform.add(new Movie("Titanic", 195, "Drama", 4.6));
        platform.add(new Movie("John Wick", 101, "Action"));
        platform.add(new Movie("The Conjuring", 112, "Horror", 3.0));
        platform.add(new Movie("Coco", 105, "Animated", 4.7));
        platform.add(new Movie("Interstellar", 169, "Science Fiction", 5));
        platform.add(new Movie("Joker", 122, "Drama"));
        platform.add(new Movie("Toy Story", 81, "Animated", 4.5));
        platform.add(new Movie("Avengers: Endgame", 181, "Action", 3.9));
    }
}
