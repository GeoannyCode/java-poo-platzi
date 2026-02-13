package platzi.play.content;

public class Movie extends Content{

    public Movie(String title, int duration, Genre genre, VideoQuality videoQuality, LanguageType languageType, double rating) {
        super(title, duration, genre, videoQuality, languageType, rating);
    }
}
