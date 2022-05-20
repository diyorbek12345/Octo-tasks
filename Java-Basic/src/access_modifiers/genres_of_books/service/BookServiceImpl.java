package access_modifiers.genres_of_books.service;

import access_modifiers.genres_of_books.entity.Book;
import access_modifiers.genres_of_books.entity.Genre;

import java.util.Arrays;

public class BookServiceImpl implements BookService {

    @Override
    public void filterBookByGenre(Book[] bookList, Genre genre) {
        for (Book book : bookList) {
            for (Genre bookGenre : book.getGenres()) {
                if (bookGenre.getAttributeOfGenre().equals(genre.getAttributeOfGenre())) {
                    if (bookGenre.equals(genre)) {
                        System.out.println("Book - " + book.getTitle() + "suitable for this filter: genre - "
                                + genre.getGenreName());
                        break;
                    } else {
                        System.out.println("Error, Book - " + book.getTitle() + "failed filter: genre"
                                + genre.getGenreName() + ", criteria - " + genre.getAttributeOfGenre()
                                + "genre is " + bookGenre.getGenreName());
                    }
                }
            }
        }
    }
}

