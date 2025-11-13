package platzi.play.platform;

import platzi.play.content.*;

public class User {
    public String name;
    public String email;

    public void watching(Movie movie){
        System.out.println(name + " is watching...");
        movie.play();
    }
}

