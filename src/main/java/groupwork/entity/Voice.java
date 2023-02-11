package groupwork.entity;


import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "app.votes")
public class Voice {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(
            name = "app.vote_artists",
            joinColumns =
            @JoinColumn(name = "voice_id"),
            inverseJoinColumns =
            @JoinColumn(nullable = false)
    )
    private Singer singer;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "app.vote_genre",
            joinColumns =
            @JoinColumn(name = "voice_id"),
            inverseJoinColumns =
            @JoinColumn(nullable = false)
    )
    private List<Genre> genres = new ArrayList<>();

    @NotNull
    private String message;
    @NotNull
    private LocalDateTime creationTime;


    public Voice() {
    }

    public Voice(Singer singer, List<Genre> genres, String message, LocalDateTime creationTime) {
        this.singer = singer;
        this.genres = genres;
        this.message = message;
        this.creationTime = creationTime;
    }

    public Long getId() {
        return id;
    }

    public Singer getSinger() {
        return singer;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }
}
