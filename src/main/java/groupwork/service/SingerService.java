package groupwork.service;

import groupwork.core.dto.GenreModelDTO;
import groupwork.core.dto.SingerCardModelDTO;
import groupwork.core.dto.SingerModelDTO;
import groupwork.dao.api.ISingerDao;
import groupwork.core.dto.SingerDTO;
import groupwork.entity.Singer;
import groupwork.service.api.ISingerService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SingerService implements ISingerService {
    private final ISingerDao dao;
    public SingerService(ISingerDao dao) {
        this.dao = dao;
    }
    @Override
    public boolean exist(long id) {
        checkId(id);
        return dao.exist(id);
    }
    @Override
    public List<SingerModelDTO> get() {
        return dao.get().stream()
                .map(s -> new SingerModelDTO(s.getName(), s.getId()))
                .collect(Collectors.toList());
    }
    @Override
    public void delete(long id, long version) {
        checkId(id);
        Singer singer = dao.get(id);
        if (singer != null && version == singer.getVersion()) {
            dao.delete(new Singer(id,version));
        } else {
            throw new IllegalArgumentException("The performer with such id is not existed");
        }
    }
    @Override
    public void insert(SingerDTO singerDTO) {
        String name = singerDTO.getName();
        checkName(name);
        dao.insert(new Singer(name));
    }
    @Override
    public void update(long id, long version, SingerDTO singerDTO) {
        String name = singerDTO.getName();
        checkName(name);
        checkId(id);
        Singer singerDao = dao.get(id);
        if (singerDao != null && singerDao.getVersion() == version) {
            dao.update(new Singer(id, version, name));
        } else {
            throw new IllegalArgumentException("The data is incorrect");
        }
    }
    @Override
    public SingerCardModelDTO get(long id) {
        checkId(id);
        Singer singerEntity = dao.get(id);
        return new SingerCardModelDTO(singerEntity.getName(),
                                      singerEntity.getId(),
                                      singerEntity.getVersion());
    }
    private void checkName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("The name of performer is not entered");
        }
    }
    private void checkId(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("The performer number is incorrect");
        }
    }
}
