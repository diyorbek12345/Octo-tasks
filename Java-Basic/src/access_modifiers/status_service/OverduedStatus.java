package access_modifiers.status_service;

import access_modifiers.Book;
import access_modifiers.BookMover;
import access_modifiers.StatusEnum;

public class OverduedStatus extends BookMover {

    @Override
    public void moveStatus(Book book, StatusEnum statusEnum) {
        if (book.getStatus() == StatusEnum.OVERDUED) {
            if (statusEnum == StatusEnum.ARCHIVED || statusEnum == StatusEnum.AVAILABLE) {
                super.moveStatus(book, statusEnum);
                System.out.print("Book status " + statusEnum+"\n");
            } else {
                System.out.println("The transfer of the book from the status "
                        + book.getStatus() + " to the status " + statusEnum + " is not possible");
            }
        }
    }
}
