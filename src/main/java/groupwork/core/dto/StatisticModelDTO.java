package groupwork.core.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class StatisticModelDTO {

    private final Map<SingerModelDTO, Integer> mapSingers;
    private final Map<GenreModelDTO, Integer> mapGenres;
    private final List<AboutRow> listUsers;


    public StatisticModelDTO(Map<SingerModelDTO, Integer> mapSingers,
                             Map<GenreModelDTO, Integer> mapGenres,
                             List<AboutRow> listUsers) {
        this.mapSingers = mapSingers;
        this.mapGenres = mapGenres;
        this.listUsers = listUsers;
    }

    public Map<SingerModelDTO, Integer> getMapSingers() {
        return mapSingers;
    }

    public Map<GenreModelDTO, Integer> getMapGenres() {
        return mapGenres;
    }
    public List<AboutRow> getListUsers() {
        return listUsers;
    }

    @Override
    public String toString() {
        return "StatisticModelDTO{" +
                "mapSingers=" + mapSingers +
                ", mapGenres=" + mapGenres +
                ", listUsers=" + listUsers +
                '}';
    }
}
