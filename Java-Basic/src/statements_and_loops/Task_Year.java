package statements_and_loops;

import java.util.Scanner;

public class Task_Year {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter year and format year must be like this 'yyyy': ");
        int year = scanner.nextInt();
        calculateYear(year); //called the method
    }

    //This method to help calculate year
    static void calculateYear(int year){
        if (year % 400 == 0){
            System.out.println("Result 366 day of year");
        } else if (year % 100 == 0) {
            System.out.println("Result 365 day of year");
        } else if (year % 4 == 0){
            System.out.println("Result 366 day of year");
        } else {
            System.out.println("Result 365 day of year");
        }
    }
}
