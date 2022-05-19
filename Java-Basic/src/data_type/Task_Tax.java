package data_type;

import java.util.Scanner;

public class Task_Tax {
    public static void main(String[] args) {

        int earnings = 0;
        int spendings = 0;
        int start = 1;
        while (start != 0) {
            System.out.println("Choose operation and enter number: \n" +
                    "1 => Add new income \n" +  //доход
                    "2 => Add new expense \n" + //расход
                    "3 => Choose a taxation system \n" + //налог
                    "4 => end"); //system stopped
            Scanner scanner = new Scanner(System.in);
            int step = scanner.nextInt();
            if (step == 4) break;

            switch (step) {
                case 1:
                    System.out.print("Add new income: ");
                    int money = scanner.nextInt();
                    earnings += money;
                    System.out.print("Your all income: " + earnings + "\n\n");
                    continue;

                case 2:
                    System.out.print("Add expense: ");
                    int spendMoney = scanner.nextInt();
                    spendings += spendMoney;
                    System.out.println("Your all expense: " + spendings + "\n");
                    continue;

                case 3:
                    System.out.println("The tax overall");
                    int taxEarning = taxEarning(earnings);
                    System.out.println("Your tax: " + taxEarning);
                    int taxEarningsMinusSpendings = taxEarningsMinusSpendings(earnings, spendings);
                    System.out.println("Tax on another system: " + taxEarningsMinusSpendings);
                    int saving = taxEarningsMinusSpendings - taxEarning;
                    System.out.println("Your saving: " + saving + "\n");
                    earnings = 0;
                    spendings = 0;
                    continue;

                default:
                    break;
            }
        }
    }

    // 6% tax
    static int taxEarning(int earnings) {
        return (earnings * 6) / 100;
    }

    // 15% tax
    static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }
}
