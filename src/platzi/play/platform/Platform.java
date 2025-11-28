package platzi.play.platform;

import platzi.play.content.Movie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Platform {
    private String name;
    private List<Movie> content;

    public Platform(String name){
        this.name = name;
        this.content = new ArrayList<>();
    }

    public void add(Movie element){
        this.content.add(element);
    }

    public List<String> getTitles(){
        return content.stream()
                .map(Movie::getTitle)
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

    public List <Movie> searchByGenre(String genre){
        return content.stream()
                .filter(content -> content.getGenre().equalsIgnoreCase(genre))
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
