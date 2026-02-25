package platzi.play.content;

public class Documentary extends Content implements Marketable{

    private String narrator;

    public Documentary(String title, int duration, Genre genre, VideoQuality videoQuality, LanguageType languageType) {
        super(title, duration, genre, videoQuality, languageType);
    }

    public Documentary(String title, int duration, Genre genre, VideoQuality videoQuality, LanguageType languageType, double rating, String narrator) {
        super(title, duration, genre, videoQuality, languageType, rating);
        this.narrator = narrator;
    }

    @Override
    public void play(){
        System.out.println("Playing the documentary " + getTitle() + " narrated by " + getNarrator());
    }

    @Override
    public String getTechnicalSheet() {
        return """
           📌 Title:    %s
           🎙️ Narrator:  %s
           ⏳ Duration:  %d min
           🎭 Genre:    %s
           📺 Quality:  %s
           🌐 Language: %s
           ⭐ Rating:    %.1f/5.0
           
           """.formatted(
                getTitle(),
                getNarrator(),
                getDuration(),
                getGenre(),
                getVideoQuality().getLabel(),
                getLanguageType().getDescription().toUpperCase(),
                getRating()

        );
    }

    @Override
    public String promote() {
        return "Discover the documentary " + this.getTitle() + " narrated by " + this.getNarrator() + ". Now on PlatziPlay!";
    }

    public String getNarrator(){
        return narrator;
    }
}
