package access_modifiers.genres_of_books.entity;

public class Genre {

    protected String attribute, genreName;

    public String getAttributeOfGenre() {
        return this.attribute;
    }

    public Genre(String attribute) {
        this.attribute = attribute;
    }

    public String getGenreName() {
        return "genre name";
    }
}
