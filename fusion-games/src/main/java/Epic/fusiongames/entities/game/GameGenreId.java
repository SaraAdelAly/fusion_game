package Epic.fusiongames.entities.game;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class GameGenreId implements Serializable {
    private static final long serialVersionUID = -3733070201665316346L;
    @Column(name = "games_id", nullable = false)
    private Integer gamesId;

    @Column(name = "genres_id", nullable = false)
    private Integer genresId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        GameGenreId entity = (GameGenreId) o;
        return Objects.equals(this.genresId, entity.genresId) &&
                Objects.equals(this.gamesId, entity.gamesId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genresId, gamesId);
    }

}