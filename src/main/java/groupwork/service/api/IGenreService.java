package groupwork.service.api;

import groupwork.core.dto.Genre.GenreCardModelDTO;
import groupwork.core.dto.Genre.GenreDTO;
import groupwork.core.dto.Genre.GenreModelDTO;

import java.util.List;

public interface IGenreService {

    boolean exist(long id);

    List<GenreModelDTO> get();

    void delete(long id,long version);

    void insert(GenreDTO genreDTO);

    void update(long id, long version, GenreDTO genreDTO);
    GenreCardModelDTO  get(long id);

}
