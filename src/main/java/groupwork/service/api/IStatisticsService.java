package groupwork.service.api;

import groupwork.core.dto.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface IStatisticsService {

    StatisticModelDTO getResult();
    public Map<SingerModelDTO, Integer> getTopSinger();
    public Map<GenreModelDTO, Integer> getTopGenre();
//    Map<LocalDateTime,String > getAboutUser();
    List<AboutRow> getAboutUser();
}
