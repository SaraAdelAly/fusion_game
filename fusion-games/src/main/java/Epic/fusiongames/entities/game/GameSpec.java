package Epic.fusiongames.entities.game;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="gamespec")
public class GameSpec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gamespec_id", nullable = false)
    private Integer gamespecId;

    private String processor;

    @Column(name = "graphics_card")
    private String graphicsCard;

    @Column(name = "dx_version")
    private Integer directXVersion;

    private Integer storage;
    private Integer memory;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameSpec gameSpec = (GameSpec) o;
        return Objects.equals(gamespecId, gameSpec.gamespecId) && Objects.equals(processor, gameSpec.processor) && Objects.equals(graphicsCard, gameSpec.graphicsCard) && Objects.equals(directXVersion, gameSpec.directXVersion) && Objects.equals(storage, gameSpec.storage) && Objects.equals(memory, gameSpec.memory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gamespecId, processor, graphicsCard, directXVersion, storage, memory);
    }

}