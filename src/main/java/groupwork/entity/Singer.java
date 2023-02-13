package groupwork.entity;

import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "app.artists")
public class Singer {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private long id;
    @Version
    private long version;
    @NotNull
    private String name;


    public Singer() {
    }

    public Singer(long id, long version, String name) {
        this.id = id;
        this.version = version;
        this.name = name;
    }

    public Singer(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Singer(long id, long version) {
        this.id = id;
        this.version = version;
    }
    public Singer(String name) {
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

}
