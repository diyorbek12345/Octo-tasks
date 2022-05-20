package access_modifiers.genres_of_books.entity;

public class Book {

    private String title;

    private Genre[] genres;

    public Book(String title, Genre[] genres) {
        this.title = title;
        this.genres = genres;
    }

    public Book(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre[] getGenres() {
        return genres;
    }

    public void setGenres(Genre[] genres) {
        this.genres = genres;
    }
}
