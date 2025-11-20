package platzi.play.platform;

import platzi.play.content.*;

import java.time.LocalDateTime;

public class User {
    private String name;
    private String email;
    private LocalDateTime registrationDate;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.registrationDate = LocalDateTime.now();
    }

    public void watching(Movie movie){
        System.out.println(name + " is watching...");
        movie.play();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
