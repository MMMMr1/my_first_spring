package groupwork.service.api;

import groupwork.core.dto.singer.SingerCardModelDTO;
import groupwork.core.dto.singer.SingerDTO;
import groupwork.core.dto.singer.SingerModelDTO;

import java.util.List;

public interface ISingerService {

    boolean exist(long id);

    List<SingerModelDTO> get();

//    void delete(SingerDTO singerDTO);
    void delete(long id, long version);

    void insert(SingerDTO singerDTO);

    void update(long id, long version, SingerDTO singerDTO);
    SingerCardModelDTO get(long id);
}
