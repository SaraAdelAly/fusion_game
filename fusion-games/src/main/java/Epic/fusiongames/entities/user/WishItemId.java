package Epic.fusiongames.entities.user;


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
public class WishItemId implements Serializable {
    private static final long serialVersionUID = 8866421444558822711L;
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "game_id", nullable = false)
    private Integer gameId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        WishItemId entity = (WishItemId) o;
        return Objects.equals(this.gameId, entity.gameId) &&
                Objects.equals(this.userId, entity.userId);
    }
    @Override
    public int hashCode() {
        return Objects.hash(gameId, userId);
    }

}