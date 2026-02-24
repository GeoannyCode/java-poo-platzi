package platzi.play.content;

public class Movie extends Content{

    public Movie(String title, int duration, Genre genre, VideoQuality videoQuality, LanguageType languageType, double rating) {
        super(title, duration, genre, videoQuality, languageType, rating);
    }
    @Override
    public void play() {
        System.out.println("The movie " + getTitle() + " is now playing");
    }

    @Override
    public String getTechnicalSheet() {
        return """
           📌 Title:    %s
           ⏳ Duration:  %d min
           🎭 Genre:    %s
           📺 Quality:  %s
           🌐 Language: %s
           ⭐ Rating:    %.1f/5.0
           """.formatted(
                getTitle(),
                getDuration(),
                getGenre(),
                getVideoQuality().getLabel(),
                getLanguageType().getDescription().toUpperCase(),
                getRating()
        );
    }
}
