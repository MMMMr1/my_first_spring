package groupwork.service;

import groupwork.core.dto.Genre.GenreCardModelDTO;
import groupwork.core.dto.Genre.GenreModelDTO;
import groupwork.dao.api.IGenreDao;
import groupwork.core.dto.Genre.GenreDTO;
import groupwork.entity.Genre;
import groupwork.service.api.IGenreService;


import java.util.List;
import java.util.stream.Collectors;

public class GenreService implements IGenreService {
    private final IGenreDao dao;
    public GenreService(IGenreDao dao) {
        this.dao = dao;
    }
    @Override
    public boolean exist(long id) {
        checkId(id);
        return dao.exist(id);
    }
    @Override
    public List<GenreModelDTO> get() {
        return dao.get().stream()
                .map(s -> new GenreModelDTO(s.getName(), s.getId()))
                .collect(Collectors.toList());
    }
    @Override
    public void delete(long id, long version) {
        checkId(id);
        Genre genre = dao.get(id);
        if (genre != null && version == genre.getVersion()) {
            dao.delete(genre);
        } else {
            throw new IllegalArgumentException("Delete is not possible." +
                    "The genre, with id ="+id+" and version = "
                    +version+", was not found in the database");
        }
    }
    @Override
    public void insert(GenreDTO genreDTO) {
        String name = genreDTO.getName();
        checkName(name);
        dao.insert(new Genre(name));
    }
    @Override
    public void update(long id, long version, GenreDTO genreDTO) {
        String name = genreDTO.getName();
        checkName(name);
        checkId(id);
        Genre genreDao = dao.get(id);
        if (genreDao != null && version == genreDao.getVersion()) {
            genreDao.setName(name);
            dao.update(genreDao);
        } else {
            throw new IllegalArgumentException("Update is not possible." +
                             "The genre, with id ="+id+" and version = "
                             +version+", was not found in the database");
        }
    }
    @Override
    public GenreCardModelDTO get(long id) {
        checkId(id);
        Genre genreEntity = dao.get(id);
        return new GenreCardModelDTO(genreEntity.getName(),
                                     genreEntity.getId(),
                                     genreEntity.getVersion());
    }
    private void checkName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("The name of performer is not entered");
        }
    }
    private void checkId(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("The performer id = "+id+ " is incorrect");
        }
    }
}
