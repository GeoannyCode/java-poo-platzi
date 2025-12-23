package platzi.play.content;

public record ContentSummary(String title, int duration, Genre genre) {
    public String toDisplayMoviesSummary(){
        StringBuilder sb = new StringBuilder();
        sb.append("🎬").append("\n");
        sb.append("Title: ").append(title).append("\n");
        sb.append("Duration: ").append(duration).append(" min").append("\n");
        sb.append("Genre: ").append(genre).append("\n");

        return sb.toString();
    }
}
