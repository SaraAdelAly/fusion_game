package Epic.fusiongames.entities.user;

import Epic.fusiongames.entities.game.Genre;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;


@Setter
@Getter
@Entity
@Table(name = "user_interest")
public class UserInterest implements Serializable {

    @EmbeddedId
    private UserInterestId id = new UserInterestId();


    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @MapsId("userId")
    @JoinColumn(name="user_id",nullable = false)
    private User user;


    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    @MapsId("genreId")
    @JoinColumn(name="genre_id",nullable = false)
    private Genre genre;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInterest that = (UserInterest) o;
        return Objects.equals(id, that.id) && Objects.equals(user, that.user) && Objects.equals(genre, that.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, genre);
    }
}
