package data_type;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Task_Removing_Extra_Spaces {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write letter: ");
        String str = scanner.nextLine();
        System.out.println("------------------------------------------------------");
        System.out.println("Removing extra spaces first option: \n" + str.trim().replaceAll("\\s{2,}", " "));
        System.out.println("------------------------------------------------------");
        System.out.println("Removing extra spaces second option: \n" + str.replaceAll("( )+", " "));
    }
}
