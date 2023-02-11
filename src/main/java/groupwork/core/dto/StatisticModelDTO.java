package groupwork.core.dto;

import java.time.LocalDateTime;
import java.util.Map;

public class StatisticModelDTO {

    private final Map<SingerModelDTO, Integer> mapSingers;
    private final Map<GenreModelDTO, Integer> mapGenres;
    private final Map<LocalDateTime, String> mapUserInfo;

    public StatisticModelDTO(Map<SingerModelDTO, Integer> mapSingers,
                             Map<GenreModelDTO, Integer> mapGenres,
                             Map<LocalDateTime, String > mapUserInfo) {
        this.mapSingers = mapSingers;
        this.mapGenres = mapGenres;
        this.mapUserInfo = mapUserInfo;
    }

    public Map<SingerModelDTO, Integer> getMapSingers() {
        return mapSingers;
    }

    public Map<GenreModelDTO, Integer> getMapGenres() {
        return mapGenres;
    }

    public Map<LocalDateTime, String> getMapUserInfo() {
        return mapUserInfo;
    }


}
