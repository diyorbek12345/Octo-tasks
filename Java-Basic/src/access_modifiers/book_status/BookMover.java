package access_modifiers.book_status;

public abstract class BookMover {

    public void moveStatus(Book book, StatusEnum statusEnum){
        System.out.println("-------------------");
        System.out.println("Moving status: ");
        book.setStatus(statusEnum);
    }
}
