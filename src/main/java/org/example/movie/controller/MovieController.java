package org.example.movie.controller;

import org.example.movie.entity.Movie;
import org.example.movie.service.MovieService;

import java.util.List;

public class MovieController {
    private final MovieService movieService = new MovieService();

    public void displayMovies() {
        List<Movie> movies = movieService.getAllMovies();
        movies.forEach(movie -> System.out.println(movie.getTitle()));
    }

    // Add endpoints for user interactions
}


