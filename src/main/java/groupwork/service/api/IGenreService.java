package groupwork.service.api;

import groupwork.core.dto.GenreCardModelDTO;
import groupwork.core.dto.GenreDTO;
import groupwork.core.dto.GenreModelDTO;

import java.util.List;

public interface IGenreService {

    boolean exist(long id);

    List<GenreModelDTO> get();

    void delete(long id);

    void insert(GenreDTO genreDTO);

    void update(long id, long version, GenreDTO genreDTO);
    GenreCardModelDTO get(long id);

}
