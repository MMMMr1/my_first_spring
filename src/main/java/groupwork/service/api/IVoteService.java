package groupwork.service.api;

import groupwork.core.dto.voice.VoiceModelDTO;
import groupwork.core.dto.voice.VoiceDTO;

import java.util.List;

public interface IVoteService {

    void save(VoiceDTO voice);
    List<VoiceModelDTO> get();
}
