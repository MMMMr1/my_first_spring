package groupwork.core.dto.Singer;

public class SingerStatisticModelDTO  extends SingerModelDTO {

    private long countVotes;

    public SingerStatisticModelDTO(String name, long id, long countVotes) {
        super(name, id);
        this.countVotes = countVotes;
    }

    public long getCountVotes() {
        return countVotes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        SingerStatisticModelDTO that = (SingerStatisticModelDTO) o;

        return countVotes == that.countVotes;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) (countVotes ^ (countVotes >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "SingerStatisticModelDTO{" +
                "countVotes=" + countVotes +
                '}';
    }
}
