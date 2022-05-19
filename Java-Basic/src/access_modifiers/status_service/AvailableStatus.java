package access_modifiers.status_service;

import access_modifiers.Book;
import access_modifiers.BookMover;
import access_modifiers.StatusEnum;

public class AvailableStatus extends BookMover {

    @Override
    public void moveStatus(Book book, StatusEnum statusEnum) {
        if (book.getStatus() == StatusEnum.AVAILABLE) {
            if (statusEnum == StatusEnum.ARCHIVED || statusEnum == StatusEnum.BORROWED) {
                super.moveStatus(book, statusEnum);
                System.out.print("Book status " + statusEnum +"\n");
            } else {
                System.out.println("The transfer of the book from the status "
                        + book.getStatus() + " to the status " + statusEnum + " is not possible");
            }
        }
    }
}
