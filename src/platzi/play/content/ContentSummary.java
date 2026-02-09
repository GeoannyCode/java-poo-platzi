package platzi.play.content;

public record ContentSummary(
        String title,
        int duration,
        Genre genre,
        VideoQuality videoQuality,
        LanguageType language,
        double rating
) {
    public String toDisplayMoviesSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append("----------------------------------\n");
        sb.append("📌 Title:    ").append(title).append("\n");
        sb.append("⏳ Duration: ").append(duration).append(" min\n");
        sb.append("🎭 Genre:    ").append(genre).append("\n");
        sb.append("📺 Quality:  ").append(videoQuality).append("\n");
        sb.append("🌐 Language: ").append(language).append("\n");
        sb.append("⭐ Rating:   ").append(rating > 0 ? rating + "/5.0" : "N/A").append("\n");
        sb.append("----------------------------------");

        return sb.toString();
    }
}
