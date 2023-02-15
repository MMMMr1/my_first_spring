package groupwork.core.dto.Singer;


public class SingerCardModelDTO extends SingerModelDTO {

    private long version;

    public SingerCardModelDTO(String name, long id, long version) {
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

        SingerCardModelDTO that = (SingerCardModelDTO) o;

        return version == that.version;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) (version ^ (version >>> 32));
        return result;
    }
}
