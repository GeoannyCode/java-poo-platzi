package platzi.play;

import platzi.play.content.*;
import platzi.play.exception.ExistingContentException;
import platzi.play.platform.*;
import platzi.play.util.FileUtils;
import platzi.play.util.ScannerUtils;

import java.util.List;
import java.util.Scanner;

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
                7. Search by type
                8. Show popular movies
                9. Play Movie
                10. Delete
                11. Exit
                -----------------------------------
                Select an option""";

    public static final int ADD_CONTENT = 1;
    public static final int SHOW_ALL = 2;
    public static final int SEARCH_BY_TITLE = 3;
    public static final int SEARCH_BY_GENRE = 4;
    public static final int SEARCH_BY_VIDEO_QUALITY = 5;
    public static final int SEARCH_BY_LANGUAGE_TYPE = 6;
    public static final int SEARCH_BY_TYPE = 7;
    public static final int SHOW_HIGH_RATING = 8;
    public static final int PLAY_MOVIE = 9;
    public static final int DELETE = 10;
    public static final int EXIT_VALUE = 11;

    public static void main(String[] args) {
        Platform platform = new Platform(NAME_PLATFORM);
        System.out.println(NAME_PLATFORM + " v" + VERSION);

        loadMovies(platform);

        System.out.println(platform.getTotalDuration() + " minutes of total content. \n");

        while (true) {
            int selectedOption = ScannerUtils.inputNumber(MENU);

            switch (selectedOption){
                case ADD_CONTENT -> {

                    int contentType = ScannerUtils.inputNumber("What type of content would you like to add?\n 1. Movie\n 2. Documentary");

                    String name = ScannerUtils.inputText("Content name");
                    Genre genre = ScannerUtils.inputGenre("Content genre");
                    VideoQuality videoQuality = ScannerUtils.inputVideoQuality("Content video quality");
                    LanguageType languageType = ScannerUtils.inputLanguageType("Content language type");
                    int duration = ScannerUtils.inputNumber("Content duration");
                    double rating = ScannerUtils.inputDecimalValue("Content rating");

                    try {
                        if (contentType == 1) {
                            platform.add(new Movie(name, duration, genre, videoQuality, languageType, rating));
                        } else {
                            String narrator = ScannerUtils.inputText("Enter the narrator's name:");
                            platform.add(new Documentary(name, duration, genre, videoQuality, languageType, rating, narrator));
                        }
                    }catch (ExistingContentException e){
                        System.out.println(e.getMessage());
                    }


                }
                case SHOW_ALL -> {
                    List<ContentSummary> titles = platform.getSummary();
                    titles.forEach(summary -> System.out.println(summary.toDisplayMoviesSummary()));
                }
                case SEARCH_BY_TITLE -> {
                    String inputName = ScannerUtils.inputText("Enter the name you want to search");
                    Content content = platform.searchByTitle(inputName);

                    if (content != null){
                        System.out.println(content.getTechnicalSheet());
                    }else {
                        System.out.println("Could not find \"" + inputName + "\" in " + platform.getName());
                    }
                }
                case SEARCH_BY_GENRE -> {
                    Genre genreSearching = ScannerUtils.inputGenre("Enter the genre you want to search: ");

                    List<Content> contentForGenre = platform.searchByGenre(genreSearching);

                    System.out.println("\n=== Search Results for Genre: " + genreSearching + " ===");
                    System.out.println("Total results: " + contentForGenre.size());
                    System.out.println("----------------------------------------");

                    int index = 1;
                    for (Content content : contentForGenre) {
                        System.out.println(index++ + ". " + content.getTitle());
                        System.out.println(content.getTechnicalSheet());
                        System.out.println();
                    }
                }

                case SEARCH_BY_VIDEO_QUALITY ->{
                    VideoQuality videoQualitySearching = ScannerUtils.inputVideoQuality("Enter the video quality you want to search: ");

                    List<Content> contentForVideoQuality = platform.searchByVideoQuality(videoQualitySearching);

                    System.out.println("\n=== Search Results for video quality: " + videoQualitySearching + " ===");
                    System.out.println("Total results: " + contentForVideoQuality.size());
                    System.out.println("----------------------------------------");

                    int index = 1;
                    for (Content content : contentForVideoQuality) {
                        System.out.println(index++ + ". " + content.getTitle());
                        System.out.println(content.getTechnicalSheet());
                        System.out.println();
                    }
                }

                case SEARCH_BY_LANGUAGE_TYPE -> {
                    LanguageType languageTypeSearching = ScannerUtils.inputLanguageType("Enter the language you want to search: ");

                    List<Content> moviesByLanguage = platform.searchByLanguageType(languageTypeSearching);

                    System.out.println("\n=== Search Results for language type: " + languageTypeSearching + " ===");
                    System.out.println("Total results: " + moviesByLanguage.size());
                    System.out.println("----------------------------------------");

                    int index = 1;
                    for (Content content : moviesByLanguage) {
                        System.out.println(index++ + ". " + content.getTitle());
                        System.out.println(content.getTechnicalSheet());
                        System.out.println();
                    }
                }

                case SEARCH_BY_TYPE -> {
                    int contentType = ScannerUtils.inputNumber("What type of content would you like to search?\n 1. Movie\n 2. Documentary");
                    if (contentType == 1){
                        List<Movie> Movies = platform.getMovies();
                        Movies.forEach(movie -> System.out.println(movie.getTechnicalSheet() + "\n"));
                    }else {
                        List<Documentary> Documentaries = platform.getDocumentary();
                        Documentaries.forEach(documentary -> System.out.println(documentary.getTechnicalSheet() + "\n"));
                    }
                }

                case SHOW_HIGH_RATING -> {
                    int count = ScannerUtils.inputNumber("Enter the count to movies do you want show");
                    List<Content> highRatingContent = platform.getPopularMovies(count);

                    highRatingContent.forEach(content -> System.out.println(content.getTechnicalSheet() + "\n"));
                }

                case PLAY_MOVIE -> {
                    String title = ScannerUtils.inputText("Title of the content to play");
                    Content content = platform.searchByTitle(title);

                    if (content != null) {
                        platform.play(content);
                    } else {
                        System.out.println(title + " does not exist.");
                    }
                }

                case DELETE -> {
                    String inputName = ScannerUtils.inputText("Please enter the number of movies to display");
                    Content content = platform.searchByTitle(inputName);

                    if (content != null){
                        platform.delete(content);
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
        platform.getContent().addAll(FileUtils.readContent());
    }
}
