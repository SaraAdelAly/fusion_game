package Epic.fusiongames.entities.order;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import Epic.fusiongames.entities.enums.DiscountType;
import Epic.fusiongames.entities.game.Game;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//import jakarta.json.bind.annotation.JsonbTransient;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="discounts")
public class Discount implements Serializable {

    @Id
    @Column(name = "discount_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer discountId;


    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private DiscountType type;

//    @JsonbTransient
    @OneToMany(mappedBy = "discount")
    private Set<Game> games;
    public Discount(DiscountType type) {
        this.type = type;
    }

    public Discount(DiscountType type, Set<Game> games) {
        this.type = type;
        this.games = games;
    }

    public String getName(){
        return this.type.name();
    }
    @Override
    public String toString() {
        return "Discount [id=" + discountId + ", type=" + type + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discount discount = (Discount) o;
        return Objects.equals(discountId, discount.discountId) && type == discount.type && Objects.equals(games, discount.games);
    }

    @Override
    public int hashCode() {
        return Objects.hash(discountId, type, games);
    }
}
