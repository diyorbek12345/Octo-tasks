package access_modifiers.genres_of_books.entity;

public class GenreByNumberOfPages extends Genre {

    public GenreByNumberOfPages() {
        super("Genre by book content");
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        GenreByNumberOfPages genreByContent = (GenreByNumberOfPages) object;

        return attribute != null && attribute.equals(genreByContent.attribute);
    }
}
