package groupwork.service.api;

import groupwork.core.dto.Genre.GenreStatisticModelDTO;
import groupwork.core.dto.Singer.SingerStatisticModelDTO;
import groupwork.core.dto.Statistic.StatisticModelDTO;
import groupwork.core.dto.Voice.AboutRow;

import java.util.List;

public interface IStatisticsService {

    StatisticModelDTO getResult();

    List<SingerStatisticModelDTO> getTopSinger();

    //    Map<SingerModelDTO, Integer> getTopSinger();
    List<GenreStatisticModelDTO> getTopGenre();

    //    Map<GenreModelDTO, Integer> getTopGenre();
    List<AboutRow> getAboutUser();
}
