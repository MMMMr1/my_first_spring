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
    @NotNull
    private String name;


    public Singer() {
    }

    public Singer(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Singer(String name) {
        this.name = name;
    }

    public Singer(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
