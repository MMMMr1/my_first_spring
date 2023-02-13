package groupwork.core.dto;

public class GenreStatisticModelDTO {
    private String name;
    private long id;
    private long countVotes;

    public GenreStatisticModelDTO(String name, long id, long countVotes) {
        this.name = name;
        this.id = id;
        this.countVotes = countVotes;
    }
    public GenreStatisticModelDTO() {
    }

    public long getCountVotes() {
        return countVotes;
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

        GenreStatisticModelDTO that = (GenreStatisticModelDTO) o;

        if (id != that.id) return false;
        if (countVotes != that.countVotes) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (countVotes ^ (countVotes >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "GenreStatisticModelDTO{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", countVotes=" + countVotes +
                '}';
    }
}
