package groupwork.core.dto;

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
