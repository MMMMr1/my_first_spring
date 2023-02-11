package groupwork.service.api;

import groupwork.entity.Voice;


public interface IMailService {
    void send(Voice savedVoiceEntity, long id);
}
