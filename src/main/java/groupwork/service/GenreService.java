package groupwork.service;

import groupwork.core.dto.GenreCardModelDTO;
import groupwork.core.dto.GenreModelDTO;
import groupwork.dao.api.IGenreDao;
import groupwork.core.dto.GenreDTO;
import groupwork.entity.Genre;
import groupwork.service.api.IGenreService;


import java.util.ArrayList;
import java.util.List;

public class GenreService implements IGenreService {

    private final IGenreDao dao;

    public GenreService(IGenreDao dao) {
        this.dao = dao;
    }

    @Override
    public boolean check(long number) {
        if (number == 0) {
            throw new IllegalArgumentException("Введите id жанра");
        }
        return this.dao.exist(number);
    }

    @Override
    public List<GenreModelDTO> get() {
        List<Genre> genreList = dao.get();

        List<GenreModelDTO> list = new ArrayList<>();

        for (Genre genreEntity : genreList) {
            list.add(new GenreModelDTO(genreEntity.getName(), genreEntity.getId()));
        }

        return list;
    }

    @Override
    public void delete(long id) {
//        long id = genreDTO.getId();
        if (id == 0) {
            throw new IllegalArgumentException("Введите номер жанра");
        }
        if (dao.exist(id)) {
            dao.delete(new Genre(id));
        } else {
            throw new IllegalArgumentException("Нет жанра для удаления с таким id");
        }
    }

    @Override
    public void insert(GenreDTO genreDTO) {
        String name = genreDTO.getName();
        if (name != null && !name.isBlank()) {
            dao.insert(new Genre(name));
        } else {
            throw new IllegalArgumentException("Не введен исполнитель");
        }
    }

    @Override
    public void update(long id, long version, GenreDTO genreDTO) {
        String genre = genreDTO.getName();

        if (genre == null || genre.isBlank()) {
            throw new IllegalArgumentException("Не введен жанр");
        }

        if (id == 0) {
            throw new IllegalArgumentException("Введите id жанра");
        }

        if (dao.exist(id)
                && version == dao.get(id).getVersion()
        ) {
            Genre genreEntity = new Genre(id, version, genre);
            dao.update(genreEntity);
        } else {
            throw new IllegalArgumentException("Нет жанра для обновления с таким id");
        }
    }

    @Override
    public GenreCardModelDTO get(long id) {
        Genre genreEntity = this.dao.get(id);
        return new GenreCardModelDTO(genreEntity.getName(), genreEntity.getId(), genreEntity.getVersion());
    }
}
