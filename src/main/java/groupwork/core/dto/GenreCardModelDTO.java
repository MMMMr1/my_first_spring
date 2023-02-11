package groupwork.core.dto;

import java.util.Objects;

public class GenreCardModelDTO {
    private String name;
    private long id;
    private long version;

    public GenreCardModelDTO(String name, long id, long version) {
        this.name = name;
        this.id = id;
        this.version = version;
    }


    public GenreCardModelDTO() {
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
        GenreCardModelDTO genreDTO = (GenreCardModelDTO) o;
        return id == genreDTO.id && Objects.equals(name, genreDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "GenreModelDTO{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", version=" + version +
                '}';
    }
}
