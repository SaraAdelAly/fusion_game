package Epic.fusiongames.entities.platform;


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
@Table(name = "platforms_games")
public class PlatformGame implements Serializable {
    @EmbeddedId
    private PlatformGameId id = new PlatformGameId();

    @MapsId("gameId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @MapsId("platformId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "platform_id", nullable = false)
    private Platform platform;



    public PlatformGame(Game game, Platform platform) {
        this.game = game;
        this.platform = platform;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlatformGame that = (PlatformGame) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(game, that.game)) return false;
        return Objects.equals(platform, that.platform);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (game != null ? game.hashCode() : 0);
        result = 31 * result + (platform != null ? platform.hashCode() : 0);
        return result;
    }
}