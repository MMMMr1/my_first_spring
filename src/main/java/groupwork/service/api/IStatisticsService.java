package groupwork.service.api;

import groupwork.core.dto.genre.GenreStatisticModelDTO;
import groupwork.core.dto.singer.SingerStatisticModelDTO;
import groupwork.core.dto.statistic.StatisticModelDTO;
import groupwork.core.dto.voice.AboutRow;

import java.util.List;

public interface IStatisticsService {

    StatisticModelDTO getResult();

    List<SingerStatisticModelDTO> getTopSinger();

    //    Map<SingerModelDTO, Integer> getTopSinger();
    List<GenreStatisticModelDTO> getTopGenre();

    //    Map<GenreModelDTO, Integer> getTopGenre();
    List<AboutRow> getAboutUser();
}
