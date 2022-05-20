package access_modifiers.genres_of_books.childGenres;

import access_modifiers.genres_of_books.entity.GenreByForm;
import access_modifiers.genres_of_books.entity.enums.GenreEnum;

public class ProseGenre extends GenreByForm {

    @Override
    public String getGenreName() {
        return GenreEnum.PROSE.name();
    }
}
