package groupwork.service.api;

import groupwork.core.dto.genre.GenreCardModelDTO;
import groupwork.core.dto.genre.GenreDTO;
import groupwork.core.dto.genre.GenreModelDTO;

import java.util.List;

public interface IGenreService {

    boolean exist(long id);

    List<GenreModelDTO> get();

    void delete(long id,long version);

    void insert(GenreDTO genreDTO);

    void update(long id, long version, GenreDTO genreDTO);
    GenreCardModelDTO  get(long id);

}
