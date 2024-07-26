package Epic.fusiongames.entities.platform;


import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import Epic.fusiongames.entities.enums.PlatformType;
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
@Table(name="platforms")
public class Platform implements Serializable {
    @Id
    @Column(name = "game_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer platformId;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private PlatformType type;

    @OneToMany(mappedBy = "platform")
    private Set<PlatformGame> platformGames;
    public Platform(PlatformType type, Set<PlatformGame> platformGames) {
        this.type = type;
        this.platformGames = platformGames;
    }
    public Platform(PlatformType type) {
        this.type = type;
    }


    public String getName(){
        return this.getType().name();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Platform platform = (Platform) o;

        if (!Objects.equals(platformId, platform.platformId)) return false;
        if (type != platform.type) return false;
        return Objects.equals(platformGames, platform.platformGames);
    }

    @Override
    public int hashCode() {
        int result = platformId != null ? platformId.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (platformGames != null ? platformGames.hashCode() : 0);
        return result;
    }
}
