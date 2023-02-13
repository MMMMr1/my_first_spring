package groupwork.core.dto;

import java.time.LocalDateTime;

public class VoiceSavedDTO implements Comparable<VoiceSavedDTO>{
    private VoiceDTO voice;
    private LocalDateTime creationTime;

    public VoiceSavedDTO(VoiceDTO voice) {
        this.voice = voice;
        this.creationTime = LocalDateTime.now();
    }
    public VoiceDTO getVoice() {
        return voice;
    }
    public void setVoice(VoiceDTO voice) {
        this.voice = voice;
    }
    public long getSinger() {
        return voice.getSinger();
    }
    public long[] getGenre() {
        return voice.getGenre();
    }
    public String getMessage() {
        return voice.getMessage();
    }
    public LocalDateTime getCreationTime() {
        return creationTime;
    }
    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }
    @Override
    public int compareTo(VoiceSavedDTO o) {
        return o.getCreationTime().compareTo(this.creationTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VoiceSavedDTO that = (VoiceSavedDTO) o;

        if (voice != null ? !voice.equals(that.voice) : that.voice != null) return false;
        return creationTime != null ? creationTime.equals(that.creationTime) : that.creationTime == null;
    }

    @Override
    public int hashCode() {
        int result = voice != null ? voice.hashCode() : 0;
        result = 31 * result + (creationTime != null ? creationTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SavedVoiceDTO{" +
                "voice=" + voice +
                ", creationTime=" + creationTime +
                '}';
    }
}
