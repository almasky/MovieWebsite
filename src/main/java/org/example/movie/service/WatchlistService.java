package org.example.movie.service;

import org.example.movie.entity.Movie;
import org.example.movie.entity.UserMovie;
import org.example.movie.entity.Watchlist;
import org.example.movie.repository.MovieRepository;
import org.example.movie.repository.UserRepository;
import org.example.movie.repository.WatchlistRepository;

import java.util.List;

public class WatchlistService {

    private final WatchlistRepository watchlistRepository = new WatchlistRepository();
    private final MovieRepository movieRepository = new MovieRepository();
    private final UserRepository userMovieRepository = new UserRepository();

    // Create a new Watchlist for a user
    public Watchlist createWatchlist(Long userId) {
        UserMovie user = userMovieRepository.findById(userId);
        if (user != null) {
            Watchlist watchlist = new Watchlist(user);
            watchlistRepository.save(watchlist);
            return watchlist;
        } else {
            throw new IllegalArgumentException("User not found");
        }
    }

    // Add a movie to the watchlist
    public void addMovieToWatchlist(Long watchlistId, Long movieId) {
        Watchlist watchlist = watchlistRepository.findById(watchlistId);
        Movie movie = movieRepository.findById(movieId);
        if (watchlist != null && movie != null) {
            watchlist.addMovie(movie);
            watchlistRepository.save(watchlist);
        }
    }

    // Remove a movie from the watchlist
    public void removeMovieFromWatchlist(Long watchlistId, Long movieId) {
        Watchlist watchlist = watchlistRepository.findById(watchlistId);
        Movie movie = movieRepository.findById(movieId);
        if (watchlist != null && movie != null) {
            watchlist.removeMovie(movie);
            watchlistRepository.save(watchlist);
        }
    }

    // Get all movies from the watchlist
    public List<Movie> getMoviesInWatchlist(Long watchlistId) {
        Watchlist watchlist = watchlistRepository.findById(watchlistId);
        return watchlist != null ? List.copyOf(watchlist.getMovies()) : List.of();
    }
}
