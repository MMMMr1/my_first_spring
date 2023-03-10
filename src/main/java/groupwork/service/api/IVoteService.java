package groupwork.service.api;

import groupwork.core.dto.SavedVoiceDTO;
import groupwork.core.dto.VoiceDTO;

import java.util.List;

public interface IVoteService {

    void save(VoiceDTO voice);
    List<SavedVoiceDTO> get();
}
