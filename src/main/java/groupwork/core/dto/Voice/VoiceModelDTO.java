package groupwork.core.dto.Voice;

import groupwork.core.dto.Genre.GenreModelDTO;
import groupwork.core.dto.Singer.SingerModelDTO;

import java.time.LocalDateTime;
import java.util.List;

public class VoiceModelDTO {
    private SingerModelDTO singer;
    private List<GenreModelDTO> genres;
    private LocalDateTime creationTime;
    private String message;

    public VoiceModelDTO(SingerModelDTO singer,
                         List<GenreModelDTO> genres,
                         LocalDateTime creationTime,
                         String message) {
        this.singer = singer;
        this.genres = genres;
        this.creationTime = creationTime;
        this.message = message;
    }

//    public VoiceModelDTO(VoiceDTO voice, LocalDateTime creationTime) {
//        this.voice = voice;
//        this.creationTime = creationTime;
//    }


    public void setSinger(SingerModelDTO singer) {
        this.singer = singer;
    }

    public void setGenres(List<GenreModelDTO> genres) {
        this.genres = genres;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SingerModelDTO getSinger() {
        return singer;
    }

    public List<GenreModelDTO> getGenres() {
        return genres;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

//    @Override
//    public int compareTo(VoiceModelDTO o) {
//        return o.getCreationTime().compareTo(this.creationTime);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VoiceModelDTO that = (VoiceModelDTO) o;

        if (singer != null ? !singer.equals(that.singer) : that.singer != null) return false;
        if (genres != null ? !genres.equals(that.genres) : that.genres != null) return false;
        if (creationTime != null ? !creationTime.equals(that.creationTime) : that.creationTime != null) return false;
        return message != null ? message.equals(that.message) : that.message == null;
    }

    @Override
    public int hashCode() {
        int result = singer != null ? singer.hashCode() : 0;
        result = 31 * result + (genres != null ? genres.hashCode() : 0);
        result = 31 * result + (creationTime != null ? creationTime.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "VoiceModelDTO{" +
                "singer=" + singer +
                ", genres=" + genres +
                ", creationTime=" + creationTime +
                ", message='" + message + '\'' +
                '}';
    }
}
