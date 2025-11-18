package platzi.play.platform;

import platzi.play.content.Movie;

public class User {
    public String name;
    public String email;

    public void ver(Movie movie){
        System.out.println(name + " is watching... ");
        movie.play();
    }
}
