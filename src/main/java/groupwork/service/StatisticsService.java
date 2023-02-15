package groupwork.service;

import groupwork.core.dto.Genre.GenreModelDTO;
import groupwork.core.dto.Genre.GenreStatisticModelDTO;
import groupwork.core.dto.Singer.SingerModelDTO;
import groupwork.core.dto.Singer.SingerStatisticModelDTO;
import groupwork.core.dto.Statistic.StatisticModelDTO;
import groupwork.core.dto.Voice.AboutRow;
import groupwork.core.dto.Voice.VoiceModelDTO;
import groupwork.service.api.IGenreService;
import groupwork.service.api.ISingerService;
import groupwork.service.api.IStatisticsService;
import groupwork.service.api.IVoteService;

import java.util.*;
import java.util.stream.Collectors;


public class StatisticsService implements IStatisticsService {

    private final IVoteService votesService;
    private final ISingerService singerService;
    private final IGenreService genreService;

    public StatisticsService(IVoteService votesService,
                             ISingerService singerService,
                             IGenreService genreService) {
        this.votesService = votesService;
        this.singerService = singerService;
        this.genreService = genreService;
    }

    @Override
    public List<SingerStatisticModelDTO> getTopSinger(){
        Map<SingerModelDTO, Integer> mapSinger = new HashMap<>();
        List<SingerModelDTO> singerDTOS = singerService.get();
        singerDTOS.stream().forEach(s -> mapSinger.put(s,0));

        for (VoiceModelDTO savedVoiceDTO : votesService.get()) {
            SingerModelDTO singer = savedVoiceDTO.getSinger();
            for (SingerModelDTO SingerDTO : singerDTOS) {
                if (singer.equals(SingerDTO) ){
                    mapSinger.put(SingerDTO, mapSinger.get(SingerDTO) + 1);
                }
            }
        }
        LinkedHashMap<SingerModelDTO, Integer> collect = sortVoice(mapSinger);
        return  collect.entrySet().stream()
                .map((k) -> new SingerStatisticModelDTO(k.getKey().getName(), k.getKey().getId(), k.getValue()))
                .collect(Collectors.toList());
    }
    @Override
    public  List<GenreStatisticModelDTO> getTopGenre(){
        Map<GenreModelDTO, Integer> mapGenre = new HashMap<>();
        List<GenreModelDTO> genreDTOS = genreService.get();
        genreDTOS.stream().forEach(s -> mapGenre.put(s,0));

        for (VoiceModelDTO savedVoiceDTO : votesService.get()) {
            List<GenreModelDTO> idGenre = savedVoiceDTO.getGenres();
            for (GenreModelDTO genreDTO : genreDTOS) {
                for (GenreModelDTO val : idGenre) {
                    if (val.equals(genreDTO)) {
                        mapGenre.put(genreDTO, mapGenre.get(genreDTO) + 1);
                    }
                }
            }
        }
        LinkedHashMap<GenreModelDTO, Integer> collect = sortVoice(mapGenre);

        return collect.entrySet().stream()
                .map((k) -> new GenreStatisticModelDTO(k.getKey().getName(), k.getKey().getId(), k.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public List<AboutRow> getAboutUser(){
        return votesService.get().stream()
                .map(s -> new AboutRow(s.getMessage(), s.getCreationTime()))
                .sorted(Comparator.comparing(AboutRow::getCreationTime).reversed())
                .collect(Collectors.toList());
    }
    @Override
    public StatisticModelDTO getResult() {
        return new StatisticModelDTO(getTopSinger(), getTopGenre(), getAboutUser());
    }

    private <T>LinkedHashMap<T, Integer> sortVoice(Map<T, Integer> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder(Integer::compare)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue
                        , (v1, v2) -> v1, LinkedHashMap::new));
    }

}
