package Epic.fusiongames.entities.order;


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
@Table(name = "ordered_games")
public class OrderedGame implements Serializable {
    @EmbeddedId
    private OrderedGameId id = new OrderedGameId();

    @MapsId("gameId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @MapsId("orderId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    public OrderedGame(Game game, Order order) {
        this.game = game;
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderedGame that = (OrderedGame) o;
        return Objects.equals(id, that.id) && Objects.equals(game, that.game) && Objects.equals(order, that.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, game, order);
    }
}