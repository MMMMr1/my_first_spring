package groupwork.core.dto;

import java.util.Objects;

public class SingerModelDTO {
    private String name;
    private long id;
    private long version;

    public SingerModelDTO(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public SingerModelDTO(String name, long id, long version) {
        this.name = name;
        this.id = id;
        this.version = version;
    }

    public SingerModelDTO(String name) {
        this.name = name;
    }

    public SingerModelDTO() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
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
