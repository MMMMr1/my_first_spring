package groupwork.service.api;

import groupwork.core.dto.SingerCardModelDTO;
import groupwork.core.dto.SingerDTO;
import groupwork.core.dto.SingerModelDTO;

import java.util.List;

public interface ISingerService {

    boolean exist(long id);

    List<SingerModelDTO> get();

//    void delete(SingerDTO singerDTO);
    void delete(long id);

    void insert(SingerDTO singerDTO);

    void update(long id, long version, SingerDTO singerDTO);
    SingerCardModelDTO get(long id);
}
