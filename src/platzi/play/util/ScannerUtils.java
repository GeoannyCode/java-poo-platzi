package platzi.play.util;

import java.util.Scanner;

public class ScannerUtils {
    public static Scanner scanner = new Scanner(System.in);

    public static String inputText(String message){
        System.out.println(message + ": ");
        return scanner.nextLine();
    }

    public static int inputNumber(String message){
        System.out.println(message + ": ");

        int data = scanner.nextInt();
        scanner.nextLine();
        return data;
    }

    public static double inputDecimalValue(String message){
        System.out.println(message + ": ");

        double data = scanner.nextDouble();
        scanner.nextLine();
        return data;
    }

}
