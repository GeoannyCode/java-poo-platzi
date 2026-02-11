package platzi.play.util;

import platzi.play.content.Genre;
import platzi.play.content.LanguageType;
import platzi.play.content.Movie;
import platzi.play.content.VideoQuality;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static final String FILE_NAME = "content.txt";
    public static final String PIPE_SEPARATOR = "|";

    public static void writeContent(Movie content){

        String line = String.join(PIPE_SEPARATOR,
                content.getTitle(),
                String.valueOf(content.getDuration()),
                String.valueOf(content.getGenre()),
                String.valueOf(content.getVideoQuality()),
                String.valueOf(content.getLanguageType()),
                String.valueOf(content.getRating())
        );

        try{
            Files.writeString(Paths.get(FILE_NAME),
                    line + System.lineSeparator(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND

            );
        }catch (IOException e){
            System.out.println("Error writing the file !!! " + e.getMessage());
        }


    }

    public static List<Movie> readContent(){
        List<Movie> contentFile = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(FILE_NAME));

            lines.forEach(line -> {
                String[] data = line.split("\\" + PIPE_SEPARATOR);

                if(data.length == 6){
                    String title = data[0];
                    int duration = Integer.parseInt(data[1]);
                    Genre genre = Genre.valueOf(data[2].toUpperCase());
                    VideoQuality videoQuality = VideoQuality.valueOf(data[3]);
                    LanguageType languageType = LanguageType.valueOf(data[4]);
                    double rating = data[5].isBlank() ? 0 : Double.parseDouble(data[5]);
                    Movie movie = new Movie(title, duration, genre, videoQuality, languageType , rating);

                    contentFile.add(movie);
                }
            });
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        return contentFile;
    }
}
