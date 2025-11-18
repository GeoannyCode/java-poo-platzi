package platzi.play.platform;

import platzi.play.content.*;

import java.time.LocalDateTime;

public class User {
    public String name;
    public String email;
    public LocalDateTime registrationDate;

    public void watching(Movie movie){
        System.out.println(name + " is watching...");
        movie.play();
    }
}

