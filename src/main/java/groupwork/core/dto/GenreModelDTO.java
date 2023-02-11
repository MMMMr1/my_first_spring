package groupwork.core.dto;

import java.util.Objects;

public class GenreModelDTO {
    private String name;
    private long id;
// todo
// private Long version;

    public GenreModelDTO(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public GenreModelDTO(String name) {
        this.name = name;
    }

    public GenreModelDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenreModelDTO genreDTO = (GenreModelDTO) o;
        return id == genreDTO.id && Objects.equals(name, genreDTO.name);
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
