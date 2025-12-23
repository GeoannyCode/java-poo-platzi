package platzi.play.platform;

import platzi.play.content.*;
import platzi.play.exception.ExistingMovieException;

import java.util.*;

public class Platform {
    private String name;
    private List<Movie> content;
    private Map<Movie, Integer> viewCount;

    public Platform(String name){
        this.name = name;
        this.content = new ArrayList<>();
        this.viewCount = new HashMap<>();
    }

    public void add(Movie element){
        Movie content = this.searchByTitle(element.getTitle());

        if(content != null){
            throw new ExistingMovieException(element.getTitle());
        }

        this.content.add(element);
    }

    public List<String> getTitles(){
        return content.stream()
                .map(Movie::getTitle)
                .toList();
    }

    public void play(Movie content) {
        int currentCount = viewCount.getOrDefault(content, 0);
        System.out.println(content.getTitle() + " has been played " + currentCount + " times.");

        viewCount.put(content, currentCount + 1);
        content.play();
    }

    public List<ContentSummary> getSummary(){
        return content.stream()
                .map(c -> new  ContentSummary(c.getTitle(), c.getDuration(), c.getGenre()))
                .toList();
    }

    public void delete(Movie element){
        this.content.remove(element);
    }

    public Movie searchByTitle(String title){
        return content.stream()
                .filter(content -> content.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    public List <Movie> searchByGenre(Genre genre){
        return content.stream()
                .filter(content -> content.getGenre().equals(genre))
                .toList();
    }

    public List <Movie> searchByVideoQuality(VideoQuality videoQuality){
        return content.stream()
                .filter(content -> content.getVideoQuality().equals(videoQuality))
                .toList();
    }


    public List <Movie> searchByLanguageType(LanguageType languageType){
        return content.stream()
                .filter(content -> content.getLanguageType().equals(languageType))
                .toList();
    }

    public List<Movie> getPopularMovies(int count){
        return content.stream()
                .sorted(Comparator.comparingDouble(Movie::getRating).reversed())
                .limit(count)
                .toList();
    }

    public int getTotalDuration(){
        return content.stream()
                .mapToInt(Movie::getDuration)
                .sum();
    }

    public String getName(){
        return name;
    }

    public List<Movie> getContent(){
        return content;
    }
}
