package access_modifiers;

import access_modifiers.status_service.ArchievedStatus;
import access_modifiers.status_service.AvailableStatus;
import access_modifiers.status_service.BorrowedStatus;
import access_modifiers.status_service.OverduedStatus;

import java.util.Scanner;

public class MainWorking {
    public static void main(String[] args) {

        int start = 1;
        while (start != 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the book name: ");
            String bookName = scanner.nextLine();
            System.out.print(
                    "'AVAILABLE' \n" +
                            "'ARCHIVED' \n" +
                            "'BORROWED' \n" +
                            "'OVERDUED' \n" +
                            "Choose status: ");
            String step = scanner.nextLine();
            switch (step) {
                case "ARCHIVED":
                    Book bookArchived = new Book(bookName, StatusEnum.ARCHIVED);
                    System.out.println(bookArchived);
                    bookMover(bookArchived);
                    break;

                case "AVAILABLE":
                    Book bookAvailable = new Book(bookName, StatusEnum.AVAILABLE);
                    System.out.println(bookAvailable);
                    bookMover(bookAvailable);
                    break;

                case "BORROWED":
                    Book bookBorrowed = new Book(bookName, StatusEnum.BORROWED);
                    System.out.println(bookBorrowed);
                    bookMover(bookBorrowed);
                    break;

                case "OVERDUED":
                    Book bookOverdued = new Book(bookName, StatusEnum.OVERDUED);
                    System.out.println(bookOverdued);
                    bookMover(bookOverdued);
                    break;

                default:
                    break;


            }

        }

    }

    static void bookMover(Book book) {
        BookMover archiveStatus = new ArchievedStatus();
        archiveStatus.moveStatus(book, StatusEnum.AVAILABLE);

        BookMover availableStatus = new AvailableStatus();
        availableStatus.moveStatus(book, StatusEnum.BORROWED);

        BookMover borrowedStatus = new BorrowedStatus();
        borrowedStatus.moveStatus(book, StatusEnum.OVERDUED);

        BookMover overduedStatus = new OverduedStatus();
        overduedStatus.moveStatus(book, StatusEnum.ARCHIVED);

        System.out.println("\nOVERALL: " + book.getStatus() + "\n");
    }
}
