package groupwork.service.api;

import groupwork.core.dto.SingerDTO;

import java.util.List;

public interface ISingerService {

    boolean check(long number);

    List<SingerDTO> getAll();

//    void delete(SingerDTO singerDTO);
    void delete(long id);

    void create(SingerDTO singerDTO);

    void update(long id, SingerDTO singerDTO);
    SingerDTO getAll(long id);
}
