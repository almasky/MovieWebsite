package org.example.movie;

import org.example.movie.controller.AdminController;
import org.example.movie.controller.MovieController;
import org.example.movie.controller.UserController;
import org.example.movie.controller.WatchlistController;

import java.util.Scanner;

public class MovieWebsiteApplication {

    public static void main(String[] args) {

        AdminController adminController = new AdminController();
        MovieController movieController = new MovieController();
        UserController userController = new UserController();
        WatchlistController watchlistController = new WatchlistController();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Movie Website Application ===");
            System.out.println("1. Manage Admins");
            System.out.println("2. Manage Content");
            System.out.println("3. Manage Users");
            System.out.println("4. Manage Watchlists");
                    System.out.println("5. Exit Application");

                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            adminController.manageAdmins();
                            break;
                        case 2:
                            movieController.manageMovies();
                            break;
                        case 3:
                            userController.UserSearchBar();
                    break;
                case 4:
                    watchlistController.manageWatchlist();
                    break;
                case 5:
                    System.out.println("Exiting application. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }
}

