package groupwork.entity;

import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "app.genres")
public class Genre {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @Version
    private long version;
    @NotNull
    private String name;


    public Genre() {
    }

    public Genre(long id, long version, String name) {
        this.id = id;
        this.version = version;
        this.name = name;
    }

    public Genre(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Genre(long id) {
        this.id = id;
    }

    public Genre(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public long getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}