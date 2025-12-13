package platzi.play.content;

public enum LanguageType {
    SPANISH("Spanish", "ES"),
    ENGLISH("English", "EN"),
    PORTUGUESE("Portuguese", "PT"),
    FRENCH("French", "FR"),
    ITALIAN("Italian", "IT");

    private final String description;
    private final String languageCode;

    LanguageType(String description, String languageCode) {
        this.description = description;
        this.languageCode = languageCode;
    }

    public String getDescription() {
        return description;
    }

    public String getLanguageCode() {
        return languageCode;
    }
}
