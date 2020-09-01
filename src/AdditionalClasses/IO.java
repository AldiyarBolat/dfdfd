package AdditionalClasses;

import java.util.Scanner;

public class IO {
    static Scanner scanner = new Scanner(System.in);

    public static String read() {
        String s  = scanner.nextLine();
        return s;
    }
    public static void print(String s) {
        System.out.println(s);
    }
}
