package Epic.fusiongames.entities.user;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import Epic.fusiongames.entities.cart.CartItem;
import Epic.fusiongames.entities.library.LibraryItem;
import Epic.fusiongames.entities.order.Order;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements Serializable, UserDetails {

    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String salt;

    @Column(name = "phonenumber", unique = true, nullable = false)
    private String phoneNumber;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    private String gender;

    @NotNull
    @Column(name = "is_admin" ,nullable = false ,columnDefinition="default '0'")
    private Byte isAdmin;

    @OneToMany(mappedBy = "orderingUser")
    private Set<Order> orders;

    @OneToMany(mappedBy = "user")
    private Set<LibraryItem> library;

    @OneToMany(mappedBy = "user")
    private List<WishItem> wishItems;

    @OneToMany(mappedBy = "user")
    private List<CartItem> cartItems;

    @Column (name= "credit_Limit")
    private Double creditLimit;


    public User(String username, String firstName, String lastName, String email, String password, String salt, String phoneNumber,
                LocalDate birthDate, String gender,String country, Byte isAdmin) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.salt = salt;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.gender = gender;
        this.country = country;
        this.isAdmin = isAdmin;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(user.phoneNumber) : user.phoneNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "User [id=" + userId + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
                + ", email=" + email + ", password=" + password + ", salt=" + salt + ", phoneNumber=" + phoneNumber
                + ", birthDate=" + birthDate + ", gender=" + gender + ", isAdmin=" + isAdmin + "]";
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(isAdmin==1?"Admin":"User"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
