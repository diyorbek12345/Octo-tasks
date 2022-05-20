package access_modifiers.genres_of_books.service;

import access_modifiers.genres_of_books.entity.Book;
import access_modifiers.genres_of_books.entity.Genre;

public interface BookService {

    void filterBookByGenre(Book[] bookList, Genre genre);
}
