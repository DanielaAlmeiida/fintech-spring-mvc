package br.com.alura.screenmatch.domain.movie;

import jakarta.persistence.*;

@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer durationInMinutes;
    private Integer releaseYear;
    private String genre;

    public Movie() {}

    public Movie(MovieRegisterData data) {
        this.name = data.name();
        this.durationInMinutes = data.duration();
        this.releaseYear = data.year();
        this.genre = data.genre();
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", durationInMinutes=" + durationInMinutes +
                ", releaseYear=" + releaseYear +
                ", genre='" + genre + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getDurationInMinutes() {
        return durationInMinutes;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public String getGenre() {
        return genre;
    }


    public void updateMovie(MovieUpdateData data) {
        this.name = data.name();
        this.durationInMinutes = data.duration();
        this.releaseYear = data.year();
        this.genre = data.genre();
    }
}
