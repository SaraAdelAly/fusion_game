package Epic.fusiongames.entities.order;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import Epic.fusiongames.entities.user.User;
import Epic.fusiongames.entities.game.Game;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.annotations.UuidGenerator.Style;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @Column(name = "order_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;


    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @Column(name = "total_price", nullable = false)
    private Double totalPrice;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = true)
    private User orderingUser;


    @OneToMany(mappedBy = "order")
    private List<OrderedGame> orderedGames;


    // public Order(LocalDate createdAt, Double totalPrice) {
    //     this.createdAt = createdAt;
    //     this.totalPrice = totalPrice;
    // }

//    {
//        totalPrice=0.0;
//    }

    public Order(LocalDate createdAt, Double totalPrice) {
        this.createdAt = createdAt;
        this.totalPrice = totalPrice;
    }
    public Order(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
      @Override
    public String toString() {
        return "Order [id=" + orderId + ", createdAt=" + createdAt + ", totalPrice=" + totalPrice + "]";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderId, order.orderId) && Objects.equals(createdAt, order.createdAt) && Objects.equals(totalPrice, order.totalPrice) && Objects.equals(orderingUser, order.orderingUser) && Objects.equals(orderedGames, order.orderedGames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, createdAt, totalPrice, orderingUser, orderedGames);
    }
}