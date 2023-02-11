package groupwork.dao.api;

import groupwork.entity.Voice;

import java.util.List;

public interface IVoteDao {
    List<Voice> get();
    long save(Voice voice);
}
