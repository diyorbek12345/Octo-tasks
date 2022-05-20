package access_modifiers.genres_of_books.childGenres;

import access_modifiers.genres_of_books.entity.GenreByContent;
import access_modifiers.genres_of_books.entity.enums.GenreEnum;

public class FantasticGenre extends GenreByContent {

    @Override
    public String getGenreName() {
        return GenreEnum.FANTASTIC.name();
    }
}
