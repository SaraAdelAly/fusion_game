package Epic.fusiongames.entities.user;


import Epic.fusiongames.entities.game.Game;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "wish_items")
public class WishItem implements Serializable {
    @EmbeddedId
    private WishItemId id = new WishItemId();

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @MapsId("gameId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    public WishItem(User user, Game game) {
        this.user = user;
        this.game = game;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WishItem wishItem = (WishItem) o;
        return Objects.equals(id, wishItem.id) && Objects.equals(user, wishItem.user) && Objects.equals(game, wishItem.game);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, game);
    }
}