package org.example.movie.service;

import org.example.movie.entity.Watchlist;

import java.util.HashMap;
import java.util.Map;

public class WatchlistService {


        private Map<String, Watchlist> watchlists;

        public WatchlistService() {
            watchlists = new HashMap<>();
        }

        public void createWatchlist(String watchlistId, String userId) {
            Watchlist watchlist = new Watchlist(watchlistId, userId);
            watchlists.put(userId, watchlist);
        }

        public void addMovie(String userId, String movieId) {
            Watchlist watchlist = watchlists.get(userId);
            if (watchlist != null) {
                watchlist.addMovie(movieId);
            }
        }

        public void removeMovie(String userId, String movieId) {
            Watchlist watchlist = watchlists.get(userId);
            if (watchlist != null) {
                watchlist.removeMovie(movieId);
            }
        }

        public void display(String userId) {
            Watchlist watchlist = watchlists.get(userId);
            if (watchlist != null) {
                watchlist.displayWatchlist();
            } else {
                System.out.println("No watchlist found for user: " + userId);
            }
        }
    }


