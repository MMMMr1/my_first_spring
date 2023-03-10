package groupwork.core.dto;

import java.time.LocalDateTime;
import java.util.Map;

public class StatisticDTO {

    private final Map<SingerDTO, Integer> mapSingers;
    private final Map<GenreDTO, Integer> mapGenres;
    private final Map<LocalDateTime, String> mapUserInfo;

    public StatisticDTO(Map<SingerDTO, Integer> mapSingers,
                        Map<GenreDTO, Integer> mapGenres,
                        Map<LocalDateTime, String > mapUserInfo) {
        this.mapSingers = mapSingers;
        this.mapGenres = mapGenres;
        this.mapUserInfo = mapUserInfo;
    }

    public Map<SingerDTO, Integer> getMapSingers() {
        return mapSingers;
    }

    public Map<GenreDTO, Integer> getMapGenres() {
        return mapGenres;
    }

    public Map<LocalDateTime, String> getMapUserInfo() {
        return mapUserInfo;
    }


}
