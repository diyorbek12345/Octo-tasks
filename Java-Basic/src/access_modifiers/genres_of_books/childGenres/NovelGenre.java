package access_modifiers.genres_of_books.childGenres;

import access_modifiers.genres_of_books.entity.GenreByNumberOfPages;
import access_modifiers.genres_of_books.entity.enums.GenreEnum;

public class NovelGenre extends GenreByNumberOfPages {
    @Override
    public String getGenreName() {
        return GenreEnum.NOVEL.name();
    }
}
