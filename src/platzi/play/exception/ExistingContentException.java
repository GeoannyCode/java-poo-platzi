package platzi.play.exception;

public class ExistingContentException extends RuntimeException{

    private static final String DEFAULT_MESSAGE = "The content already exist in the platform.";

    public ExistingContentException(String message){
        super(DEFAULT_MESSAGE);
    }
}
