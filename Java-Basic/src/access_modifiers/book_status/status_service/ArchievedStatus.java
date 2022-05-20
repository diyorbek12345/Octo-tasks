package access_modifiers.book_status.status_service;

import access_modifiers.book_status.Book;
import access_modifiers.book_status.BookMover;
import access_modifiers.book_status.StatusEnum;

public class ArchievedStatus extends BookMover {

    @Override
    public void moveStatus(Book book, StatusEnum statusEnum) {
        if (book.getStatus() == StatusEnum.ARCHIVED) {
            if (statusEnum == StatusEnum.AVAILABLE) {
                super.moveStatus(book, statusEnum);
                System.out.print("Book status " + statusEnum+"\n");
            } else {
                System.out.println("The transfer of the book from the status "
                        + book.getStatus() + " to the status " + statusEnum + " is not possible");
            }
        }
    }
}
