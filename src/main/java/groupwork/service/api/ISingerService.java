package groupwork.service.api;

import groupwork.core.dto.SingerDTO;
import groupwork.core.dto.SingerModelDTO;

import java.util.List;

public interface ISingerService {

    boolean check(long number);

    List<SingerModelDTO> get();

//    void delete(SingerDTO singerDTO);
    void delete(long id);

    void insert(SingerDTO singerDTO);

    void update(long id, SingerDTO singerDTO);
    SingerModelDTO get(long id);
}
