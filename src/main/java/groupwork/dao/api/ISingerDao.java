package groupwork.dao.api;

import groupwork.entity.Singer;

import java.util.List;

public interface ISingerDao {
    List<Singer> get();

    boolean exist (long id);

    void delete(Singer singer);

    void insert(Singer singer);

    void update(Singer singer);
    Singer get(long id);
}
