package groupwork.core.dto.Statistic;

import groupwork.core.dto.Genre.GenreStatisticModelDTO;
import groupwork.core.dto.Singer.SingerStatisticModelDTO;
import groupwork.core.dto.Voice.AboutRow;

import java.util.List;

public class StatisticModelDTO {
    private final List<SingerStatisticModelDTO> singers;
    private final List<GenreStatisticModelDTO> genres;
    private final List<AboutRow> aboutRows;

    public StatisticModelDTO(List<SingerStatisticModelDTO> singers,
                             List<GenreStatisticModelDTO> genres,
                             List<AboutRow> aboutRows) {
        this.singers = singers;
        this.genres = genres;
        this.aboutRows = aboutRows;
    }


    public List<SingerStatisticModelDTO> getSingers() {
        return singers;
    }

    public List<GenreStatisticModelDTO> getGenres() {
        return genres;
    }

    public List<AboutRow> getAboutRows() {
        return aboutRows;
    }
}
