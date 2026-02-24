package platzi.play.content;

import java.time.LocalDate;

public abstract class Content {

    // Attributes
    private final String title;
    private String description;
    private int duration;
    private Genre genre;
    private VideoQuality videoQuality;
    private LanguageType languageType;
    private LocalDate releaseDate;
    private double rating;
    private boolean available;

    public Content(String title, int duration, Genre genre, VideoQuality videoQuality, LanguageType languageType){
        this.title = title;
        this.duration = duration;
        this.genre = genre;
        this.videoQuality = videoQuality;
        this.languageType = languageType;
        this.releaseDate = LocalDate.now();
        this.available = true;
    }

    public Content(String title, int duration, Genre genre, VideoQuality videoQuality, LanguageType languageType, double rating) {
        this(title, duration, genre, videoQuality, languageType);
        this.rate(rating);
    }

    // Methods
    public abstract void play();

    public abstract String getTechnicalSheet();

    public void rate(double rating){
        if (rating >= 0 && rating <= 10){
            this.rating = rating;
        }
    }

    public boolean isPopular(){
        return rating >= 8;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getDuration() {
        return duration;
    }

    public Genre getGenre() {
        return genre;
    }

    public VideoQuality getVideoQuality(){
        return videoQuality;
    }

    public LanguageType getLanguageType() {return languageType;}

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public double getRating() {
        return rating;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setVideoQuality(VideoQuality videoQuality){this.videoQuality = videoQuality;}

    public void setLanguageType(LanguageType languageType){this.languageType = languageType;}

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

