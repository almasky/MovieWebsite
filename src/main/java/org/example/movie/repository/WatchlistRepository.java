package org.example.movie.repository;

import org.example.movie.entity.Watchlist;

import java.util.HashMap;
import java.util.Map;

public class WatchlistRepository {

    private final Map<String, Watchlist> watchlists = new HashMap<>();

    public void save(Watchlist watchlist) {
        if (watchlist == null || watchlist.getWatchlistId() == null) {
            throw new IllegalArgumentException("Watchlist or Watchlist ID cannot be null.");
        }
        watchlists.put(watchlist.getWatchlistId(), watchlist);
    }

    public Watchlist findById(String watchlistId) {
        if (watchlistId == null) {
            throw new IllegalArgumentException("Watchlist ID cannot be null.");
        }
        return watchlists.get(watchlistId);
    }

    public void delete(String watchlistId) {
        if (watchlistId == null) {
            throw new IllegalArgumentException("Watchlist ID cannot be null.");
        }
        watchlists.remove(watchlistId);
    }

    public Map<String, Watchlist> findAll() {
        return new HashMap<>(watchlists);
    }
}
