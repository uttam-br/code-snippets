package helper;

import java.util.Scanner;

public class InputProcessor {
    public static final Scanner scanner = new Scanner(System.in);

    public static String readString(String prompt) {
        System.out.println(prompt);
        return scanner.next();
    }

    public static int readInt(String prompt) {
        System.out.println(prompt);
        return scanner.nextInt();
    }

}
