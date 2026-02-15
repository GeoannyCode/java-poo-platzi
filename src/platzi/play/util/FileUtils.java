package platzi.play.util;

import platzi.play.content.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static final String FILE_NAME = "content.txt";
    public static final String PIPE_SEPARATOR = "|";

    public static void writeContent(Content content){

        String line = String.join(PIPE_SEPARATOR,
                content.getTitle(),
                String.valueOf(content.getDuration()),
                String.valueOf(content.getGenre()),
                String.valueOf(content.getVideoQuality()),
                String.valueOf(content.getLanguageType()),
                String.valueOf(content.getRating())
        );

        String finalLine;

        if(content instanceof Documentary documentary){
            finalLine = "DOCUMENTARY" + PIPE_SEPARATOR + line + PIPE_SEPARATOR + documentary.getNarrator();
        }else {
            finalLine = "MOVIE" + PIPE_SEPARATOR + line;
        }

        try{
            Files.writeString(Paths.get(FILE_NAME),
                    finalLine + System.lineSeparator(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
        }catch (IOException e){
            System.out.println("Error writing the file !!! " + e.getMessage());
        }


    }

    public static List<Content> readContent(){
        List<Content> contentFile = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(FILE_NAME));

            lines.forEach(line -> {
                String[] data = line.split("\\" + PIPE_SEPARATOR);
                String contentType = data[0];

                if(("MOVIE".equals(contentType) && data.length == 7) || ("DOCUMENTARY".equals(contentType) && data.length == 8)){
                    String title = data[1];
                    int duration = Integer.parseInt(data[2]);
                    Genre genre = Genre.valueOf(data[3].toUpperCase());
                    VideoQuality videoQuality = VideoQuality.valueOf(data[4]);
                    LanguageType languageType = LanguageType.valueOf(data[5]);
                    double rating = data[6].isBlank() ? 0 : Double.parseDouble(data[6]);
                    Content content;

                    if("MOVIE".equals(contentType)){
                        content = new Movie(title, duration, genre, videoQuality, languageType , rating);
                    }else {
                        String narrator = data[7];
                        content = new Documentary(title, duration, genre, videoQuality, languageType , rating, narrator);
                    }

                    contentFile.add(content);
                }
            });
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        return contentFile;
    }
}
