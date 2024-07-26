package Epic.fusiongames.entities.library;


import Epic.fusiongames.entities.user.User;
import Epic.fusiongames.entities.game.Game;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "library")
public class LibraryItem {
    @EmbeddedId
    private LibraryItemId id = new LibraryItemId();

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.REFRESH)
    @MapsId("userId")
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.REFRESH)
    @MapsId("gameId")
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    public LibraryItem(User user, Game game) {
        this.user = user;
        this.game = game;
    }

    @Override
    public String toString() {
        return "LibraryItem{" +
                "id=" + id +
                ", user=" + user +
                ", game=" + game +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibraryItem that = (LibraryItem) o;
        return Objects.equals(id, that.id) && Objects.equals(user, that.user) && Objects.equals(game, that.game);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, game);
    }
}