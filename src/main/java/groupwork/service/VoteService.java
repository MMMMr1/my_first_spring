package groupwork.service;

import groupwork.core.dto.*;
import groupwork.dao.api.IVoteDao;
import groupwork.entity.Genre;
import groupwork.entity.Voice;
import groupwork.entity.Singer;
import groupwork.service.api.IGenreService;
import groupwork.service.api.ISingerService;
import groupwork.service.api.IVoteService;

import java.time.LocalDateTime;
import java.util.*;

public class VoteService implements IVoteService {
    private final IVoteDao voiceDao;

    private final ISingerService singerService;

    private final IGenreService genreService;

    public VoteService(IVoteDao voiceDao,
                       ISingerService singerService,
                       IGenreService genreService) {
        this.voiceDao = voiceDao;
        this.singerService = singerService;
        this.genreService = genreService;
    }

    @Override
    public void save(VoiceDTO voice) {
        check(voice);

        VoiceSavedDTO savedVoiceDTO = new VoiceSavedDTO(voice);

        LocalDateTime creationTime = savedVoiceDTO.getCreationTime();
        String message = savedVoiceDTO.getMessage();

        long  singerId = savedVoiceDTO.getSinger();
        SingerModelDTO singerModelDTO = singerService.get(singerId);

        Singer singer = new Singer(singerModelDTO.getId(), singerModelDTO.getName());

        List<Genre> genres = new ArrayList<>();
        for (long genreId : savedVoiceDTO.getGenre()) {
            GenreCardModelDTO genreModelDTO = genreService.get(genreId);
            genres.add(new Genre(genreModelDTO.getId(), genreModelDTO.getName()));
        }

        Voice savedVoice = new Voice(singer, genres, message, creationTime);
        voiceDao.save(savedVoice);
    }


    @Override
    public List<VoiceModelDTO> get() {
        List<VoiceModelDTO> savedVoiceDTOS = new ArrayList<>();
        List<Voice> all = voiceDao.get();
        for (Voice voice : all) {
            LocalDateTime creationTime = voice.getCreationTime();
            String message = voice.getMessage();

            Singer singer = voice.getSinger();
            SingerModelDTO singers = new SingerModelDTO(singer.getName(), singer.getId());

            List<GenreModelDTO> genre = new ArrayList<>();
            for (Genre val :voice.getGenres()) {
                genre.add(new GenreModelDTO(val.getName(), val.getId()));
            }

            savedVoiceDTOS.add(new VoiceModelDTO(singers, genre, creationTime,message));
        }
        return savedVoiceDTOS;
    }

    private void check(VoiceDTO voice) {
        long singer = voice.getSinger();
        if (!singerService.check(voice.getSinger())) {
            throw new IllegalArgumentException("Артист №" + singer + " отсутствует в списке выбора");
        }

        long[] genres = voice.getGenre();

        Set<Long> setGenre = new HashSet<>();

        for (long val : genres) {
            setGenre.add(val);
        }

        if (setGenre.size() < 3 || setGenre.size() > 5) {
            throw new IllegalArgumentException("Неверное количество жанров, должно быть от 3 до 5");
        }

        if (setGenre.size() != genres.length) {
            throw new IllegalArgumentException("Переданные жанры содержат дубли");
        }

        for (Long genre : setGenre) {
            if (!genreService.check(genre)) {
                throw new IllegalArgumentException("Введенный жанр №" + genre + " не содержится в списке");
            }
        }

        String aboutMe = voice.getMessage();
        if (aboutMe == null || aboutMe.isBlank()) {
            throw new IllegalArgumentException("Нужно ввести информацию о себе");
        }

//        String email = voice.getMail();
//        Pattern pattern = Pattern.compile("^[a-zA-Z0-9!#$%&'*+/=?^_`{|},~\\-]+(?:\\\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~\\-]+)*@+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?+\\.+[a-zA-Z]*$");
//        if (!pattern.matcher(email).matches()) {
//            throw new IllegalArgumentException("E-MAIL IS NOT CORRECT");
//        }
    }
}
