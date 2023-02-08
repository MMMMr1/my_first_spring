package groupwork.service;

import groupwork.core.dto.StatisticDTO;
import groupwork.core.dto.GenreDTO;
import groupwork.core.dto.SavedVoiceDTO;
import groupwork.core.dto.SingerDTO;
import groupwork.service.api.IGenreService;
import groupwork.service.api.ISingerService;
import groupwork.service.api.IStatisticsService;
import groupwork.service.api.IVoteService;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;


public class StatisticsService implements IStatisticsService {

    private final IVoteService iVotesService;
    private final ISingerService iSingerService;
    private final IGenreService iGenreService;


    public StatisticsService(IVoteService iVotesService,
                             ISingerService iSingerService,
                             IGenreService iGenreService) {
        this.iVotesService = iVotesService;
        this.iSingerService = iSingerService;
        this.iGenreService = iGenreService;
    }
    @Override
    public Map<SingerDTO, Integer> getTopSinger(){
        Map<SingerDTO, Integer> mapSinger = new HashMap<>();
        List<SingerDTO> singerDTOS = iSingerService.getAll();
        for (SingerDTO singer : singerDTOS) {
            mapSinger.put(singer, 0);
        }
        List<SavedVoiceDTO> savedVoiceDTOS = iVotesService.get();
        for (SavedVoiceDTO savedVoiceDTO : savedVoiceDTOS) {
            long idSinger = savedVoiceDTO.getSinger();
            for (SingerDTO SingerDTO : singerDTOS) {
                if (idSinger == SingerDTO.getId()) {
                    mapSinger.put(SingerDTO, mapSinger.get(SingerDTO) + 1);
                }
            }
        }return  mapSinger.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder(Integer::compare)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue
                        , (v1, v2) -> v1, LinkedHashMap::new));
    }
    @Override
    public Map<GenreDTO, Integer> getTopGenre(){
        Map<GenreDTO, Integer> mapGenre = new HashMap<>();
        List<GenreDTO> genreDTOS = iGenreService.getAll();

        for (GenreDTO genreDTO : genreDTOS) {
            mapGenre.put(genreDTO, 0);
        }
        List<SavedVoiceDTO> savedVoiceDTOS = iVotesService.get();
        for (SavedVoiceDTO savedVoiceDTO : savedVoiceDTOS) {
            long[] idGenre = savedVoiceDTO.getGenre();
            for (GenreDTO genreDTO : genreDTOS) {
                for (long i : idGenre) {
                    if (i == genreDTO.getId()) {
                        mapGenre.put(genreDTO, mapGenre.get(genreDTO) + 1);
                    }
                }
            }
        }return mapGenre.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder(Integer::compare)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue
                        , (v1, v2) -> v1, LinkedHashMap::new));
    }
    @Override
    public Map<LocalDateTime,String > getAboutUser(){
        List<SavedVoiceDTO> savedVoiceDTOS = iVotesService.get();
        Map<LocalDateTime,String> mapUser = new HashMap<>();
        for (SavedVoiceDTO savedVoiceDTO : savedVoiceDTOS) {
            mapUser.put(savedVoiceDTO.getCreationTime(),savedVoiceDTO.getMessage());
        }
        return mapUser.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Collections.reverseOrder(LocalDateTime::compareTo)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue
                        , (v1, v2) -> v1, LinkedHashMap::new));
    }
    @Override
    public StatisticDTO getResult() {
        return new StatisticDTO(getTopSinger(),getTopGenre(),getAboutUser());
    }
}
