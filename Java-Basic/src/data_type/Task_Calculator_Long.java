package data_type;

import java.util.Scanner;

public class Task_Calculator_Long {
    public static void main(String[] args) {

        int start = 1;
        while (start != 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Write 2 variables of type long, you should write 'start' \n" +
                    "If you stop program, you should enter 'end' word");
            String step = scanner.nextLine();
            if (step.equals("end")) break;
            switch (step) {
                case "start":
                    System.out.print("Enter the first number: ");
                    long first = scanner.nextLong();
                    System.out.print("Enter the second number: ");
                    long second = scanner.nextLong();
                    System.out.println("Choose operation: \n ABS, \n DIV, \n DIV_ROUND, \n POW");
                    Operation operation = Operation.valueOf(scanner.next().trim());
                    calculate(first, second, operation);
                    System.out.println("-----------------------------------------------");
                    break;

                default:
                    break;
            }
        }
    }


    private static void calculate(long value1, long value2, Operation operation) {
        switch (operation) {
            case ABS:
                System.out.printf("value1 abs = %s %n", Math.abs(value1));
                System.out.printf("value2 abs = %s %n", Math.abs(value2));
                break;
            case DIV:
                System.out.printf("div = %s %n", (double) value1 / value2);
                break;
            case DIV_ROUND:
                System.out.printf("round div = %s %n", Math.round((double) value1 / value2));
                break;
            case POW:
                System.out.printf("pow = %s %n", Math.pow(value1, value2));
                break;
        }
    }

    public enum Operation {
        DIV,
        ABS,
        DIV_ROUND,
        POW
    }
}
