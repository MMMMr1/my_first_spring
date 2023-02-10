package groupwork.service.api;

import groupwork.core.dto.GenreDTO;

import java.util.List;

public interface IGenreService {

    boolean check(long number);

    List<GenreDTO> get();

    void delete(long id);

    void insert(GenreDTO genreDTO);

    void update(long id, GenreDTO genreDTO);
    GenreDTO get(long id);

}
