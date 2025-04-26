package org.example.movie.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Type type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genre genre;


    public Movie(String title, Type type, Genre genre) {
        this.title = title;
        this.type = type;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Movie [title=" + title + ", type=" + type + ", genre=" + genre + "]";
    }

}
