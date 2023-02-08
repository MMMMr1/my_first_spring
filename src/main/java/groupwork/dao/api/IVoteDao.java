package groupwork.dao.api;

import groupwork.entity.SavedVoice;

import java.util.List;

public interface IVoteDao {
    List<SavedVoice> get();
    long save(SavedVoice voice);
}
