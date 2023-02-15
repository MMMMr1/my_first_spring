package groupwork.service.api;

import groupwork.core.dto.Singer.SingerCardModelDTO;
import groupwork.core.dto.Singer.SingerDTO;
import groupwork.core.dto.Singer.SingerModelDTO;

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
