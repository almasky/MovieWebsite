package org.example.movie.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.movie.entity.Genre;
import org.example.movie.entity.Type;

@Getter
@Setter

public class MovieDto {
    private Long movieId;
    private String title;
    private Genre genre;
    private Type type;


}
