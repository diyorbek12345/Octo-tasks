package data_type;

import java.net.Socket;
import java.util.Scanner;

public class Task_Double {
    public static void main(String[] args) {

        int start = 1;
        while (start != 0) {
            System.out.println("Operation double and float \n" +
                    "1 => Compare \n" +
                    "2 => Round up \n" +
                    "3 => Discard the fractional part \n" +
                    "4 => end"); //system stopped
            Scanner scanner = new Scanner(System.in);
            int step = scanner.nextInt();
            if (step == 4) break;

            switch (step) {
                case 1:
                    System.out.print("Write first number: ");
                    double firstNumber = scanner.nextDouble();
                    System.out.print("Write second number: ");
                    float secondNumber = scanner.nextFloat();
                    System.out.println("Result: " + compareBetweenNumbers(firstNumber, secondNumber) + "\n");
                    continue;

                case 2:
                    System.out.print("Write number: ");
                    double number = scanner.nextDouble();
                    long roundUp = Math.round(number);
                    System.out.println("Result: " + roundUp + "\n");
                    continue;

                case 3:
                    System.out.println("Write number: ");
                    double Number = scanner.nextDouble();
                    long fractionalNumber = (long) Number;
                    System.out.println("Result: " + fractionalNumber + "\n");
                    continue;

                default:
                    break;
            }

        }
    }

    static String compareBetweenNumbers(double firstNumber, float secondNumber) {
        if (Math.abs(firstNumber - secondNumber) < 0.000001)
            return "Equals";
        else if (firstNumber > secondNumber)
            return "The first number is greater than the second";
        else
            return "The second number is greater than the first";
    }
}
