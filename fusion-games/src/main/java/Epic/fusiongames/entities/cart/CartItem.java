package Epic.fusiongames.entities.cart;


import Epic.fusiongames.entities.game.Game;
import Epic.fusiongames.entities.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cart_items")

public class CartItem {
    @EmbeddedId
    private CartItemId id = new CartItemId();

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @MapsId("gameId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;


    public CartItem(User user, Game game) {
        this.user = user;
        this.game = game;
    }


}