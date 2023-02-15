package groupwork.core.dto.Genre;

public class GenreCardModelDTO extends GenreModelDTO {

    private long version;

    public GenreCardModelDTO(String name, long id, long version) {
        super(name, id);
        this.version = version;
    }

    public long getVersion() {
        return version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        GenreCardModelDTO that = (GenreCardModelDTO) o;

        return version == that.version;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) (version ^ (version >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "GenreCardModelDTO{" +
                "version=" + version +
                '}';
    }
}
