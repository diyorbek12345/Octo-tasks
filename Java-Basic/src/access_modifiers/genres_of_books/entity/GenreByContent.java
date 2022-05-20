package access_modifiers.genres_of_books.entity;

public class GenreByContent extends Genre {

    public GenreByContent() {
        super("Genre by book content");
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        GenreByContent genreByContent = (GenreByContent) object;

        return attribute != null && attribute.equals(genreByContent.attribute);
    }
}
