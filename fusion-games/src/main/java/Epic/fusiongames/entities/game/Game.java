package Epic.fusiongames.entities.game;


import java.time.LocalDate;
import java.util.Set;
import Epic.fusiongames.entities.cart.CartItem;
import Epic.fusiongames.entities.platform.PlatformGame;
import Epic.fusiongames.entities.user.*;
import Epic.fusiongames.entities.library.LibraryItem;
import Epic.fusiongames.entities.order.Discount;
import Epic.fusiongames.entities.order.OrderedGame;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Check;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="games")
public class Game {
    @Id
    @Column(name = "game_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gameId;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "discount_id")
    private Discount discount;

    @Column(nullable = false)
    private String developer;

    @Column(nullable = false)
    private String publisher;

    @Column(unique = true, nullable = false)
    private String pictureUrl;

    @Column(unique = true, nullable = false)
    private String gameFileUrl;

    @Column(nullable = false)
    private String description;

    @Column(name = "net_price",nullable = false)
    private Double netPrice;

    @OneToMany(mappedBy = "game")
    private Set<LibraryItem> owners;

    @OneToMany(mappedBy = "game")
    private Set<WishItem> wishItems;

    @OneToMany(mappedBy = "game")
    private Set<CartItem> carts;

    @OneToMany(mappedBy = "game")
    private Set<OrderedGame> orders;

    @Column( name = "release_date", nullable = false)
    @Check(constraints = "release_date <= CURRENT_DATE")
    private LocalDate releaseDate;

    @OneToMany(mappedBy = "game")
    private Set<GameGenre> genres;

    @OneToMany(mappedBy = "game")
    private Set<PlatformGame> platforms;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "minimum_spec_id", nullable = false)
    private GameSpec minimumSpec;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recommended_spec_id", nullable = false)
    private GameSpec recommendedSpec;

    public Game( GameSpec minimumSpec, GameSpec recommendedSpec) {
        this.minimumSpec = minimumSpec;
        this.recommendedSpec = recommendedSpec;
    }
    public Game(String name, Double price, String developer, String publisher, String pictureUrl, String description, LocalDate releaseDate) {
        this.name = name;
        this.price = price;
        this.developer = developer;
        this.publisher = publisher;
        this.pictureUrl = pictureUrl;
        this.description = description;
        this.releaseDate = releaseDate;
        this.netPrice = price;
        try {
            releaseDate.getClass().getField("year").setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String toString() {
        return "Game [id=" + gameId + ", name=" + name + ", price=" + price + ", developer=" + developer + ", publisher="
                + publisher + ", pictureUrl=" + pictureUrl + ", description=" + description + ", releaseDate="
                + releaseDate + ", discount=" + discount + ", genres=" + genres + ", platforms=" + platforms + "]";
    }







//    public void setPrice(Double price) {
//        this.price = price;
//        if(discount!=null)
//            netPrice = price - (price * discount.getType().getDiscount()/100);
//        else
//            netPrice = price;
//    }


//
//    public List<User> getWishingUsers() {
//        return Collections.unmodifiableList(wishItems.stream().map(WishItem::getUser).toList());
//    }
//
//
//    public List<Genre> getGenres() {
//        return Collections.unmodifiableList(genres.stream().map(GameGenre::getGenre).toList());
//    }
//
//
//    public List<User> getOwners() {
//        return Collections.unmodifiableList(owners.stream().map(LibraryItem::getUser).toList());
//    }
//
//
//    public List<User> getUsersFromCarts() {
//        return Collections.unmodifiableList(carts.stream().map(CartItem::getUser).toList());
//    }
//
//
//    public List<Order> getOrders() {
//        return Collections.unmodifiableList(orders.stream().map(OrderedGame::getOrder).toList());
//    }
//    public List<Platform> getPlatfomrs() {
//        return Collections.unmodifiableList(platforms.stream().map(PlatformGame::getPlatform).toList());
//    }


//    public Set<LibraryItem> getLibraryItems() {
//        return owners;
//    }


//    public Set<CartItem> getCartItems() {
//        return carts;
//    }
//
//    public Set<OrderedGame> getOrderedGames() {
//        return orders;
//    }
//
//    public Set<PlatformGame> getPlatformGames() {
//        return platforms;
//    }
//
//    public Set<GameGenre> getGameGenres() {
//        return genres;
//    }


}