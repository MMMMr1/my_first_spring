package groupwork.service;

import groupwork.dao.api.ISingerDao;
import groupwork.core.dto.SingerDTO;
import groupwork.entity.Singer;
import groupwork.service.api.ISingerService;

import java.util.ArrayList;
import java.util.List;

public class SingerService implements ISingerService {

    private final ISingerDao dao;

    public SingerService(ISingerDao dao) {
        this.dao = dao;
    }

    @Override
    public boolean check(long number) {
        if (number == 0) {
            throw new IllegalArgumentException("Введите номер исполнителя");
        }
        return this.dao.exist(number);

    }

    @Override
    public List<SingerDTO> get() {
        List<Singer> singerList = dao.get();

        List<SingerDTO>list = new ArrayList<>();

        for (Singer singerEntity : singerList) {
            list.add(new SingerDTO(singerEntity.getName(), singerEntity.getId()));
        }

        return list;
    }

    @Override
    public void delete(long id) {
//        long id = singerDTO.getId();
        if(dao.exist(id)){
            dao.delete(new Singer(id));
        }else {
            throw new IllegalArgumentException("Нет исполнителя для удаления с таким id");
        }
    }

    @Override
    public void create(SingerDTO singerDTO) {
        String name = singerDTO.getName();
        if (name != null && !name.isBlank()) {
            dao.insert(new Singer(name));
        } else {
            throw new IllegalArgumentException("Не введен исполнитель");
        }
    }

    @Override
    public void update(long id, SingerDTO singerDTO) {
        String singer = singerDTO.getName();
        if (singer == null || singer.isBlank()) {
            throw new IllegalArgumentException("Не введено новое имя исполнителя");
        }

        if(dao.exist(id)){
            dao.update(new Singer(id, singer));
        } else {
            throw new IllegalArgumentException("Нет исполнителя для обновления с таким id");
        }
    }

    @Override
    public SingerDTO get(long id) {
        Singer singerEntity = this.dao.get(id);
        return new SingerDTO(singerEntity.getName(), singerEntity.getId());

    }
}
