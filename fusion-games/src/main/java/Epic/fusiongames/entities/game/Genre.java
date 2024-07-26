package Epic.fusiongames.entities.game;



import java.util.Objects;
import java.util.Set;

import Epic.fusiongames.entities.enums.GenreType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="genres")
public class Genre{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id", nullable = false)
    private Integer genreId;


    @Enumerated(EnumType.STRING)
    @Column(name="genre", unique = true, nullable = false)
    private GenreType genre;

    @OneToMany(mappedBy = "genre")
    private Set<GameGenre> gameGenres;



    public Genre(GenreType genre, Set<GameGenre> gameGenres) {
        this.genre = genre;
        this.gameGenres = gameGenres;
    }
    public Genre(GenreType genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Genre [id=" + genreId + ", genre=" + genre + "]";
    }

    public String getName(){
        return genre.getGenre();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Genre genre1 = (Genre) o;

        if (!Objects.equals(genreId, genre1.genreId)) return false;
        if (genre != genre1.genre) return false;
        return Objects.equals(gameGenres, genre1.gameGenres);
    }

    @Override
    public int hashCode() {
        int result = genreId != null ? genreId.hashCode() : 0;
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (gameGenres != null ? gameGenres.hashCode() : 0);
        return result;
    }
}