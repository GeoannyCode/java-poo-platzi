package platzi.play.exception;

public class ExistingMovieException extends RuntimeException{

    private static final String DEFAULT_MESSAGE = "The movie already exist in the platform.";

    public ExistingMovieException(String message){
        super(DEFAULT_MESSAGE);
    }
}
