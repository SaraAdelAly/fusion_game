package Epic.fusiongames.entities.review;

import Epic.fusiongames.entities.game.Game;
import Epic.fusiongames.entities.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "game_review")
public class GameReview implements Serializable {
    @EmbeddedId
    private GameReviewId id=new GameReviewId();

    @MapsId("gameId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Size(max = 500)
    @Column(name = "review", length = 500)
    private String review;


    @Column(name = "review_date")
    private Timestamp reviewDate;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameReview that = (GameReview) o;
        return Objects.equals(id, that.id) && Objects.equals(game, that.game) && Objects.equals(user, that.user) && Objects.equals(review, that.review) && Objects.equals(reviewDate, that.reviewDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, game, user, review, reviewDate);
    }
}
