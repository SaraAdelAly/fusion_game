package Epic.fusiongames.entities.order;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;
@Getter
@Setter
@Embeddable
public class OrderedGameId implements Serializable {
    private static final long serialVersionUID = -111631734670454815L;
    @Column(name = "game_id", nullable = false)
    private Integer gameId;


    @Column(name = "order_id", nullable = false)
    private Integer orderId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OrderedGameId entity = (OrderedGameId) o;
        return Objects.equals(this.gameId, entity.gameId) &&
                Objects.equals(this.orderId, entity.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, orderId);
    }

}