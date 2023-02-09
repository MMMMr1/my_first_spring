package groupwork.service;

import groupwork.dao.api.IVoteDao;
import groupwork.core.dto.GenreDTO;
import groupwork.core.dto.SavedVoiceDTO;
import groupwork.core.dto.SingerDTO;
import groupwork.core.dto.VoiceDTO;
import groupwork.entity.Genre;
import groupwork.entity.SavedVoice;
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

    public VoteService(IVoteDao voiceDao, ISingerService singerService, IGenreService genreService) {
        this.voiceDao = voiceDao;
        this.singerService = singerService;
        this.genreService = genreService;
    }

    @Override
    public void save(VoiceDTO voice) {
        check(voice);

        SavedVoiceDTO savedVoiceDTO = new SavedVoiceDTO(voice);

//        String email = savedVoiceDTO.getMail();
        LocalDateTime creationTime = savedVoiceDTO.getCreationTime();
        String message = savedVoiceDTO.getMessage();

        long  singer_id = savedVoiceDTO.getSinger();
        SingerDTO s = singerService.get(singer_id);
        Singer singer = new Singer(s.getId(), s.getName());

        List<Genre> genres = new ArrayList<>();
        for (long genre_id : savedVoiceDTO.getGenre()) {
            GenreDTO genreDTO = genreService.get(genre_id);
            genres.add(new Genre(genreDTO.getId(), genreDTO.getName()));
        }

        SavedVoice savedVoice = new SavedVoice(singer, genres, message, creationTime );
        voiceDao.save(savedVoice);
    }


    @Override
    public List<SavedVoiceDTO> get() {
        List<SavedVoiceDTO> savedVoiceDTOS = new ArrayList<>();
        List<SavedVoice> all = voiceDao.get();
        for (SavedVoice voice : all) {
            LocalDateTime creationTime = voice.getCreationTime();
            String message = voice.getMessage();
            Long id_singer = voice.getSinger().getId();

            List<Genre> genre = voice.getGenres();
            long[] genres = new long[genre.size()];
            for (int i = 0; i < genres.length; i++) {
                genres[i] = genre.get(i).getId();
            }

            VoiceDTO voiceDTO = new VoiceDTO(id_singer, genres, message);
            savedVoiceDTOS.add(new SavedVoiceDTO(voiceDTO, creationTime));
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
