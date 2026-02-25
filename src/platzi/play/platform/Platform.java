package platzi.play.platform;
import platzi.play.content.*;
import platzi.play.exception.ExistingContentException;
import platzi.play.util.FileUtils;

import java.util.*;

public class Platform {
    private String name;
    private List<Content> content;
    private Map<Content, Integer> viewCount;

    public Platform(String name){
        this.name = name;
        this.content = new ArrayList<>();
        this.viewCount = new HashMap<>();
    }

    public void add(Content element){
        Content content = this.searchByTitle(element.getTitle());

        if(content != null){
            throw new ExistingContentException(element.getTitle());
        }

        FileUtils.writeContent(element);
        this.content.add(element);
    }

    public List<String> getTitles(){
        return content.stream()
                .map(Content::getTitle)
                .toList();
    }

    public void play(Content content) {
        int currentCount = viewCount.getOrDefault(content, 0);
        System.out.println(content.getTitle() + " has been played " + currentCount + " times.");

        viewCount.put(content, currentCount + 1);
        content.play();
    }

    public List<ContentSummary> getSummary() {
        return content.stream()
                .map(c -> new ContentSummary(
                        c.getTitle(),
                        c.getDuration(),
                        c.getGenre(),
                        c.getVideoQuality(),
                        c.getLanguageType(),
                        c.getRating()
                ))
                .toList();
    }

    public void delete(Content element){
        this.content.remove(element);
    }

    public Content searchByTitle(String title){
        return content.stream()
                .filter(content -> content.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    public List <Content> searchByGenre(Genre genre){
        return content.stream()
                .filter(content -> content.getGenre().equals(genre))
                .toList();
    }

    public List <Content> searchByVideoQuality(VideoQuality videoQuality){
        return content.stream()
                .filter(content -> content.getVideoQuality().equals(videoQuality))
                .toList();
    }


    public List <Content> searchByLanguageType(LanguageType languageType){
        return content.stream()
                .filter(content -> content.getLanguageType().equals(languageType))
                .toList();
    }

    public List<Content> getPopularMovies(int count){
        return content.stream()
                .sorted(Comparator.comparingDouble(Content::getRating).reversed())
                .limit(count)
                .toList();
    }

    public List<Movie> getMovies(){
        return content.stream()
                .filter(content -> content instanceof Movie)
                .map(filteredContent -> (Movie) filteredContent)
                .toList();
    }

    public List<Documentary> getDocumentary(){
        return content.stream()
                .filter(content -> content instanceof Documentary)
                .map(filteredContent -> (Documentary) filteredContent)
                .toList();
    }

    public List<Marketable> getMarketables(){
        return content.stream()
                .filter(content -> content instanceof Marketable)
                .map(filteredContent -> (Marketable) filteredContent)
                .toList();
    }

    public int getTotalDuration(){
        return content.stream()
                .mapToInt(Content::getDuration)
                .sum();
    }

    public String getName(){
        return name;
    }

    public List<Content> getContent(){
        return content;
    }
}
