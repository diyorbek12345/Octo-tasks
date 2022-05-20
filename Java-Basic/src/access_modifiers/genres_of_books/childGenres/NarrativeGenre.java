package access_modifiers.genres_of_books.childGenres;

import access_modifiers.genres_of_books.entity.GenreByNumberOfPages;
import access_modifiers.genres_of_books.entity.enums.GenreEnum;

public class NarrativeGenre extends GenreByNumberOfPages {
    @Override
    public String getGenreName() {
        return GenreEnum.NARRATIVE.name();
    }
}
