package groupwork.service;

import groupwork.core.dto.*;
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
    public Map<SingerModelDTO, Integer> getTopSinger(){
        Map<SingerModelDTO, Integer> mapSinger = new HashMap<>();
        List<SingerModelDTO> singerDTOS = iSingerService.get();
        for (SingerModelDTO singer : singerDTOS) {
            mapSinger.put(singer, 0);
        }
        List<VoiceModelDTO> savedVoiceDTOS = iVotesService.get();
        for (VoiceModelDTO savedVoiceDTO : savedVoiceDTOS) {
            long idSinger = savedVoiceDTO.getSinger();
            for (SingerModelDTO SingerDTO : singerDTOS) {
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
    public Map<GenreModelDTO, Integer> getTopGenre(){
        Map<GenreModelDTO, Integer> mapGenre = new HashMap<>();
        List<GenreModelDTO> genreDTOS = iGenreService.get();

        for (GenreModelDTO genreDTO : genreDTOS) {
            mapGenre.put(genreDTO, 0);
        }
        List<VoiceModelDTO> savedVoiceDTOS = iVotesService.get();
        for (VoiceModelDTO savedVoiceDTO : savedVoiceDTOS) {
            long[] idGenre = savedVoiceDTO.getGenre();
            for (GenreModelDTO genreDTO : genreDTOS) {
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
        List<VoiceModelDTO> savedVoiceDTOS = iVotesService.get();
        Map<LocalDateTime,String> mapUser = new HashMap<>();
        for (VoiceModelDTO savedVoiceDTO : savedVoiceDTOS) {
            mapUser.put(savedVoiceDTO.getCreationTime(),savedVoiceDTO.getMessage());
        }
        return mapUser.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Collections.reverseOrder(LocalDateTime::compareTo)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue
                        , (v1, v2) -> v1, LinkedHashMap::new));
    }
    @Override
    public StatisticModelDTO getResult() {
        return new StatisticModelDTO(getTopSinger(),getTopGenre(),getAboutUser());
    }
}
