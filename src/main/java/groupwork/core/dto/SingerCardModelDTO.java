package groupwork.core.dto;

import java.util.Objects;

public class SingerCardModelDTO {
    private String name;
    private long id;
    private long version;

    public SingerCardModelDTO(String name, long id, long version) {
        this.name = name;
        this.id = id;
        this.version = version;
    }

    public SingerCardModelDTO(String name) {
        this.name = name;
    }

    public SingerCardModelDTO() {
    }

    public long getVersion() {
        return version;
    }
    public String getName() {
        return name;
    }
    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SingerCardModelDTO that = (SingerCardModelDTO) o;

        if (id != that.id) return false;
        if (version != that.version) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (version ^ (version >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "SingerCardModelDTO{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", version=" + version +
                '}';
    }
}
