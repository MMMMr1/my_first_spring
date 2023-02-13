package groupwork.service.api;

import groupwork.core.dto.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface IStatisticsService {

    StatisticModelDTO getResult();

    List<SingerStatisticModelDTO> getTopSinger();

    //    Map<SingerModelDTO, Integer> getTopSinger();
    List<GenreStatisticModelDTO> getTopGenre();

    //    Map<GenreModelDTO, Integer> getTopGenre();
    List<AboutRow> getAboutUser();
}
