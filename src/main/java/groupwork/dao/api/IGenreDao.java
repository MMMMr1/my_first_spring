package groupwork.dao.api;

import groupwork.entity.Genre;

import java.util.List;

public interface IGenreDao {
    List<Genre> get();

    boolean exist (long id);
    void delete(Genre genre);

    void insert(Genre genre);

//    void update(long version,Genre genre);
    void update(Genre genre);
    Genre get(long id);
}
