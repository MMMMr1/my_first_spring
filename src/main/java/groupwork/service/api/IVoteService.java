package groupwork.service.api;

import groupwork.core.dto.Voice.VoiceModelDTO;
import groupwork.core.dto.Voice.VoiceDTO;

import java.util.List;

public interface IVoteService {

    void save(VoiceDTO voice);
    List<VoiceModelDTO> get();
}
