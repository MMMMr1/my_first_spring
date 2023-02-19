package groupwork.core.dto.singer;

import java.util.Objects;

public class SingerModelDTO {
    private String name;
    private long id;
    public SingerModelDTO(String name, long id) {
        this.name = name;
        this.id = id;
    }
    public SingerModelDTO() {
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getId() { return id;}
    public void setId(long id) {
        this.id = id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingerModelDTO singerDTO = (SingerModelDTO) o;
        return id == singerDTO.id && Objects.equals(name, singerDTO.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
    @Override
    public String toString() {
        return "id = " + id + ",  name = " + name;
    }
}
