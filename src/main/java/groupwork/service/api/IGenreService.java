package groupwork.service.api;

import groupwork.core.dto.GenreDTO;
import groupwork.core.dto.GenreModelDTO;

import java.util.List;

public interface IGenreService {

    boolean check(long number);

    List<GenreModelDTO> get();

    void delete(long id);

    void insert(GenreDTO genreDTO);

    void update(long id, GenreDTO genreDTO);
    GenreModelDTO get(long id);

}
