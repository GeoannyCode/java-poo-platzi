package platzi.play.util;

import java.util.Scanner;

public class ScannerUtils {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static String inputText(String message){
        System.out.println(message + ": ");
        return SCANNER.nextLine();
    }

    public static int inputNumber(String message){
        System.out.println(message + ": ");

        int data = SCANNER.nextInt();
        SCANNER.nextLine();
        return data;
    }

    public static double inputDecimalValue(String message){
        System.out.println(message + ": ");

        double data = SCANNER.nextDouble();
        SCANNER.nextLine();
        return data;
    }

}
