package org.example.movie.service;

import org.example.movie.entity.Movie;
import org.example.movie.repository.MovieRepository;

import java.util.List;

public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService() {
        this.movieRepository = new MovieRepository();
    }

    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public void updateMovie(Movie movie) {
        movieRepository.update(movie);
    }

    public void deleteMovieById(Long id) {
        movieRepository.deleteById(id);
    }
}
