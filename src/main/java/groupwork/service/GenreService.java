package groupwork.service;

import groupwork.core.dto.GenreCardModelDTO;
import groupwork.core.dto.GenreModelDTO;
import groupwork.dao.api.IGenreDao;
import groupwork.core.dto.GenreDTO;
import groupwork.entity.Genre;
import groupwork.service.api.IGenreService;


import java.util.ArrayList;
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
    public void delete(long id) {
        if (dao.exist(id)) {
            dao.delete(new Genre(id));
        } else {
            throw new IllegalArgumentException("The genre with such id is not exist");
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
            dao.update(new Genre(id, version, name));
        } else {
            throw new IllegalArgumentException("The data is incorrect");
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
            throw new IllegalArgumentException("The performer number is incorrect");
        }
    }
}
