package groupwork.service.api;

import groupwork.core.dto.GenreDTO;

import java.util.List;

public interface IGenreService {

    boolean check(long number);

    List<GenreDTO> getAll();

    void delete(long id);

    void create(GenreDTO genreDTO);

    void update(long id, GenreDTO genreDTO);
    GenreDTO getAll(long id);

}
