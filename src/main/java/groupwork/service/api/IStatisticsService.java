package groupwork.service.api;

import groupwork.core.dto.GenreDTO;
import groupwork.core.dto.SingerDTO;
import groupwork.core.dto.StatisticDTO;

import java.time.LocalDateTime;
import java.util.Map;

public interface IStatisticsService {

    StatisticDTO getResult();
    public Map<SingerDTO, Integer> getTopSinger();
    public Map<GenreDTO, Integer> getTopGenre();
    Map<LocalDateTime,String > getAboutUser();
}
