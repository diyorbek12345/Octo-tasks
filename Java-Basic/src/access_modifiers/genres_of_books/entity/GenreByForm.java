package access_modifiers.genres_of_books.entity;

public class GenreByForm extends Genre {

    public GenreByForm() {
        super("Genre by book content");
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        GenreByForm genreByContent = (GenreByForm) object;

        return attribute != null && attribute.equals(genreByContent.attribute);
    }
}
