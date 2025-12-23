package platzi.play;

import platzi.play.content.*;
import platzi.play.exception.ExistingMovieException;
import platzi.play.platform.*;
import platzi.play.util.ScannerUtils;

import java.util.List;

public class Main {
    public static final String NAME_PLATFORM = "PLATZI PLAY";
    public static final String VERSION = "1.0.0";

    private static final String MENU = """
                ************** MENU **************
                1. Add content
                2. Show all
                3. Search by title
                4. Search by genre
                5. Search by video quality
                6. Search by language
                7. Show popular movies
                8. Play Movie
                9. Delete
                10. Exit
                -----------------------------------
                Select an option""";

    public static final int ADD_CONTENT = 1;
    public static final int SHOW_ALL = 2;
    public static final int SEARCH_BY_TITLE = 3;
    public static final int SEARCH_BY_GENRE = 4;
    public static final int SEARCH_BY_VIDEO_QUALITY = 5;
    public static final int SEARCH_BY_LANGUAGE_TYPE = 6;
    public static final int SHOW_HIGH_RATING = 7;
    public static final int PLAY_MOVIE = 8;
    public static final int DELETE = 9;
    public static final int EXIT_VALUE = 10;

    public static void main(String[] args) {
        Platform platform = new Platform(NAME_PLATFORM);
        System.out.println(NAME_PLATFORM + " v" + VERSION);

        loadMovies(platform);

        System.out.println(platform.getTotalDuration() + " minutes of total content. \n");

        while (true) {
            int selectedOption = ScannerUtils.inputNumber(MENU);

            switch (selectedOption){
                case ADD_CONTENT -> {
                    String name = ScannerUtils.inputText("Content name");
                    Genre genre = ScannerUtils.inputGenre("Content genre");
                    VideoQuality videoQuality = ScannerUtils.inputVideoQuality("Content video quality");
                    LanguageType languageType = ScannerUtils.inputLanguageType("Content language type");
                    int duration = ScannerUtils.inputNumber("Content duration");
                    double rating = ScannerUtils.inputDecimalValue("Content rating");

                    try {
                        Movie movie = new Movie(name, duration, genre, videoQuality, languageType,  rating);
                        platform.add(movie);
                    }catch (ExistingMovieException e){
                        System.out.println(e.getMessage());
                    }


                }
                case SHOW_ALL -> {
                    List<ContentSummary> titles = platform.getSummary();
                    titles.forEach(summary -> System.out.println(summary.toDisplayMoviesSummary()));
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
                case SEARCH_BY_GENRE -> {
                    Genre genreSearching = ScannerUtils.inputGenre("Enter the genre you want to search: ");

                    List<Movie> contentForGenre = platform.searchByGenre(genreSearching);

                    System.out.println("\n=== Search Results for Genre: " + genreSearching + " ===");
                    System.out.println("Total results: " + contentForGenre.size());
                    System.out.println("----------------------------------------");

                    int index = 1;
                    for (Movie content : contentForGenre) {
                        System.out.println(index++ + ". " + content.getTitle());
                        System.out.println(content.getTechnicalSheet());
                        System.out.println();
                    }
                }

                case SEARCH_BY_VIDEO_QUALITY ->{
                    VideoQuality videoQualitySearching = ScannerUtils.inputVideoQuality("Enter the video quality you want to search: ");

                    List<Movie> contentForVideoQuality = platform.searchByVideoQuality(videoQualitySearching);

                    System.out.println("\n=== Search Results for video quality: " + videoQualitySearching + " ===");
                    System.out.println("Total results: " + contentForVideoQuality.size());
                    System.out.println("----------------------------------------");

                    int index = 1;
                    for (Movie content : contentForVideoQuality) {
                        System.out.println(index++ + ". " + content.getTitle());
                        System.out.println(content.getTechnicalSheet());
                        System.out.println();
                    }
                }

                case SEARCH_BY_LANGUAGE_TYPE -> {
                    LanguageType languageTypeSearching = ScannerUtils.inputLanguageType("Enter the language you want to search: ");

                    List<Movie> moviesByLanguage = platform.searchByLanguageType(languageTypeSearching);

                    System.out.println("\n=== Search Results for language type: " + languageTypeSearching + " ===");
                    System.out.println("Total results: " + moviesByLanguage.size());
                    System.out.println("----------------------------------------");

                    int index = 1;
                    for (Movie content : moviesByLanguage) {
                        System.out.println(index++ + ". " + content.getTitle());
                        System.out.println(content.getTechnicalSheet());
                        System.out.println();
                    }
                }

                case SHOW_HIGH_RATING -> {
                    int count = ScannerUtils.inputNumber("Enter the count to movies do you want show");
                    List<Movie> highRatingContent = platform.getPopularMovies(count);

                    highRatingContent.forEach(content -> System.out.println(content.getTechnicalSheet() + "\n"));
                }

                case PLAY_MOVIE -> {
                    String title = ScannerUtils.inputText("Title of the content to play");
                    Movie content = platform.searchByTitle(title);

                    if (content != null) {
                        platform.play(content);
                    } else {
                        System.out.println(title + " does not exist.");
                    }
                }

                case DELETE -> {
                    String inputName = ScannerUtils.inputText("Please enter the number of movies to display");
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
        platform.add(new Movie("Shrek", 90, Genre.ANIMATED, VideoQuality.HIGH, LanguageType.ENGLISH));
        platform.add(new Movie("Inception", 148, Genre.SCIENCE_FICTION, VideoQuality.LOW, LanguageType.SPANISH));
        platform.add(new Movie("Titanic", 195, Genre.DRAMA, VideoQuality.HIGH, LanguageType.FRENCH, 4.6));
        platform.add(new Movie("John Wick", 101, Genre.ACTION, VideoQuality.MEDIUM, LanguageType.PORTUGUESE));
        platform.add(new Movie("The Conjuring", 112, Genre.HORROR, VideoQuality.HD, LanguageType.ENGLISH, 3.0));
        platform.add(new Movie("Coco", 105, Genre.ANIMATED, VideoQuality.MEDIUM, LanguageType.SPANISH, 4.7));
        platform.add(new Movie("Interstellar", 169, Genre.SCIENCE_FICTION, VideoQuality.HIGH, LanguageType.ITALIAN, 5));
        platform.add(new Movie("Joker", 122, Genre.DRAMA, VideoQuality.MEDIUM, LanguageType.ENGLISH));
        platform.add(new Movie("Toy Story", 81, Genre.ANIMATED, VideoQuality.LOW, LanguageType.FRENCH, 4.5));
        platform.add(new Movie("Avengers: Endgame", 181, Genre.ACTION, VideoQuality.HD, LanguageType.PORTUGUESE, 3.9));
    }
}
