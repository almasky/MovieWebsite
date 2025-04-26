package org.example.movie.entity;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Watchlist {

        private String watchlistId;
        private String userId;
        private Set<String> movieIds;

        public Watchlist(String watchlistId, String userId) {
            this.watchlistId = watchlistId;
            this.userId = userId;
            this.movieIds = new HashSet<>();
        }

        public void addMovie(String movieId) {
            movieIds.add(movieId);
        }

        public void removeMovie(String movieId) {
            movieIds.remove(movieId);
        }

        public void displayWatchlist() {
            System.out.println("Watchlist for User: " + userId);
            if (movieIds.isEmpty()) {
                System.out.println("No movies in watchlist.");
            } else {
                for (String movieId : movieIds) {
                    System.out.println("- " + movieId);
                }
            }
        }
    }


