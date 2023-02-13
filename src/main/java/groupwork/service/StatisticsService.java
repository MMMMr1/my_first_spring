package groupwork.service;

import groupwork.core.dto.*;
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
//        todo Map -> to List of Row<K,T>
        Map<SingerModelDTO, Integer> mapSinger = new HashMap<>();
        List<SingerModelDTO> singerDTOS = singerService.get();
        for (SingerModelDTO singer : singerDTOS) {
            mapSinger.put(singer, 0);
        }
        List<VoiceModelDTO> savedVoiceDTOS = votesService.get();
        for (VoiceModelDTO savedVoiceDTO : savedVoiceDTOS) {
            SingerModelDTO singer = savedVoiceDTO.getSinger();
            for (SingerModelDTO SingerDTO : singerDTOS) {
                if (singer.equals(SingerDTO) ){
                    mapSinger.put(SingerDTO, mapSinger.get(SingerDTO) + 1);
                }
            }
        }
        LinkedHashMap<SingerModelDTO, Integer> collect = mapSinger.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder(Integer::compare)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue
                        , (v1, v2) -> v1, LinkedHashMap::new));

        return  collect.entrySet().stream().map((k) -> new SingerStatisticModelDTO(k.getKey().getName(), k.getKey().getId(), k.getValue())).collect(Collectors.toList());
    }
    @Override
    public  List<GenreStatisticModelDTO> getTopGenre(){
        Map<GenreModelDTO, Integer> mapGenre = new HashMap<>();
        List<GenreModelDTO> genreDTOS = genreService.get();

        for (GenreModelDTO genreDTO : genreDTOS) {
            mapGenre.put(genreDTO, 0);
        }
        List<VoiceModelDTO> savedVoiceDTOS = votesService.get();
        for (VoiceModelDTO savedVoiceDTO : savedVoiceDTOS) {
            List<GenreModelDTO> idGenre = savedVoiceDTO.getGenres();
            for (GenreModelDTO genreDTO : genreDTOS) {
                for (GenreModelDTO val : idGenre) {
                    if (val.equals(genreDTO)) {
                        mapGenre.put(genreDTO, mapGenre.get(genreDTO) + 1);
                    }
                }
            }
        }
        LinkedHashMap<GenreModelDTO, Integer> collect = mapGenre.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder(Integer::compare)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue
                        , (v1, v2) -> v1, LinkedHashMap::new));
        return collect.entrySet().stream().map((k) -> new GenreStatisticModelDTO(k.getKey().getName(), k.getKey().getId(), k.getValue())).collect(Collectors.toList());
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
}
