package platzi.play.util;

import platzi.play.content.Genre;
import platzi.play.content.LanguageType;
import platzi.play.content.VideoQuality;

import java.util.Arrays;
import java.util.Scanner;

public class ScannerUtils {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static String inputText(String message){
        System.out.println(message + ": \n");
        return SCANNER.nextLine();
    }

    public static int inputNumber(String message){
        System.out.println(message + ": ");

        while (!SCANNER.hasNextInt()) {
            System.out.println("Input not accepted. " + message + ": ");
            SCANNER.next();
        }

        int data = SCANNER.nextInt();
        SCANNER.nextLine();
        return data;
    }

    public static double inputDecimalValue(String message){
        System.out.println(message + ": ");

        while (!SCANNER.hasNextDouble()) {
            System.out.println("Input not accepted. " + message + ": ");
            SCANNER.next();
        }

        double data = SCANNER.nextDouble();
        SCANNER.nextLine();
        return data;
    }

    public static Genre inputGenre(String message){
        System.out.println("Available genres: " + Arrays.toString(Genre.values()));

        while(true){
            String input = inputText(message).trim().toUpperCase();

            try {
                return Genre.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.printf("'%s' is not a valid genre. Please try again.%n%n", input);
            }
        }
    }

    public static VideoQuality inputVideoQuality(String message){
        System.out.println("Available video Qualities: " + Arrays.toString(VideoQuality.values()));

        while(true){
            String input = inputText(message).trim().toUpperCase();

            try {
                return VideoQuality.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.printf("'%s' is not a valid video quality. Please try again.%n%n", input);
            }
        }
    }

    public static LanguageType inputLanguageType(String message){
        System.out.println("Available languages: " + Arrays.toString(LanguageType.values()));

        while (true){
            String input = inputText(message).trim().toUpperCase();

            try {
                return LanguageType.valueOf(input);
            } catch (IllegalArgumentException e){
                System.out.printf("'%s' is not a valid language. Please try again.%n%n", input);
            }
        }
    }
}
