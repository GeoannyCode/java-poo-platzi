package platzi.play.content;

public class Documentary extends Content{

    private String narrator;

    public Documentary(String title, int duration, Genre genre, VideoQuality videoQuality, LanguageType languageType) {
        super(title, duration, genre, videoQuality, languageType);
    }

    public Documentary(String title, int duration, Genre genre, VideoQuality videoQuality, LanguageType languageType, double rating, String narrator) {
        super(title, duration, genre, videoQuality, languageType, rating);
        this.narrator = narrator;
    }

    public String getNarrator(){
        return narrator;
    }
}
