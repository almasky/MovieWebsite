package org.example.movie.controller;

import org.example.movie.entity.Movie;
import org.example.movie.entity.UserMovie;
import org.example.movie.service.WatchlistService;

import java.util.Scanner;

public class WatchlistController {

    private final WatchlistService watchlistService = new WatchlistService();
    private final Scanner scanner = new Scanner(System.in);

    public void manageWatchlist() {
        while (true) {
            System.out.println("\nWatchlist Management:");
            System.out.println("1. Create Watchlist for User");
            System.out.println("2. Add Movie to Watchlist");
            System.out.println("3. Remove Movie from Watchlist");
            System.out.println("4. View Movies in Watchlist");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter User ID to Create Watchlist:");
                    Long userId = scanner.nextLong();
                    scanner.nextLine(); // Consume newline
                    watchlistService.createWatchlist(userId);
                    System.out.println("Watchlist created for User with ID " + userId);
                    break;

                case 2:
                    System.out.println("Enter Watchlist ID:");
                    Long watchlistId = scanner.nextLong();
                    System.out.println("Enter Movie ID to Add to Watchlist:");
                    Long movieId = scanner.nextLong();
                    watchlistService.addMovieToWatchlist(watchlistId, movieId);
                    System.out.println("Movie added to Watchlist");
                    break;

                case 3:
                    System.out.println("Enter Watchlist ID:");
                    Long removeWatchlistId = scanner.nextLong();
                    System.out.println("Enter Movie ID to Remove from Watchlist:");
                    Long removeMovieId = scanner.nextLong();
                    watchlistService.removeMovieFromWatchlist(removeWatchlistId, removeMovieId);
                    System.out.println("Movie removed from Watchlist");
                    break;

                case 4:
                    System.out.println("Enter Watchlist ID to View Movies:");
                    Long viewWatchlistId = scanner.nextLong();
                    watchlistService.getMoviesInWatchlist(viewWatchlistId)
                            .forEach(movie -> System.out.println(movie.getTitle()));
                    break;

                case 5:
                    System.out.println("Exiting Watchlist Management...");
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
