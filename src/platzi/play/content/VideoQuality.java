package platzi.play.content;

public enum VideoQuality {
    LOW("Low quality", 240, "240p"),
    MEDIUM("Medium quality", 360, "360p"),
    HIGH("High quality", 720, "720p"),
    HD("HD quality", 1080, "1080p");

    private final String description;
    private final int resolution;
    private final String label;

    VideoQuality(String description, int resolution, String label) {
        this.description = description;
        this.resolution = resolution;
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public int getResolution() {
        return resolution;
    }

    public String getLabel() {
        return label;
    }
}
