package org.example.movie.controller;

import org.example.movie.entity.AdminMovie;
import org.example.movie.entity.Genre;
import org.example.movie.entity.Movie;
import org.example.movie.entity.UserMovie;
import org.example.movie.service.UserService;

import java.util.List;
import java.util.Scanner;

public class UserController {

    private final UserService userService = new UserService();
    public void UserSearchBar() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nUser search bar:");
            System.out.println("1. Add user");
            System.out.println("2. Display all users");
            System.out.println("3. Delete a user");
            System.out.println("4. Search by title");
            System.out.println("5. Search by genre");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 4:
                    System.out.println("Enter Movie title:");
                    String title = scanner.nextLine();
                    UserMovie user = userService.getMovieByTitle(title);
                    Movie movie = new Movie();
                    if (user != null) {
                        System.out.println("Movie Details -> ID: " + movie.getId() + ", Type: " + movie.getType() + ", Genre: " + movie.getGenre());
                    } else {
                        System.out.println("Movie not found!");
                    }
                    break;
                case 5:
                    System.out.println("Enter Movie genre:");
                    String genre = scanner.nextLine();
                    UserMovie user1 = userService.getMovieByGenre(Genre.valueOf(genre.toUpperCase()));
                    Movie movie1 = new Movie();
                    if (user1 != null) {
                        System.out.println("Movie Details -> ID: " + movie1.getId() + ", Type: " + movie1.getType() + ", Genre: " + movie1.getGenre());
                    } else {
                        System.out.println("Movie not found!");
                    }
                    break;

                case 6:
                    System.out.println("Exiting User search bar...");
                    return;
                case 1:
                    System.out.println("Enter User Email:");
                    String email = scanner.nextLine();
                    System.out.println("Enter User Username:");
                    String username = scanner.nextLine();
                    System.out.println("Enter User Password:");
                    String password = scanner.nextLine();

                    UserMovie user2 = new UserMovie(email, username, password);
                    userService.addUser(user2);
                    System.out.println("User added successfully!");
                    break;

                case 2:
                    System.out.println("All Users:");
                    userService.getAllUsers().forEach(u ->
                            System.out.println("ID: " + u.getId() +
                                    ", Email: " + u.getEmail() +
                                    ", Username: " + u.getUsername()));
                    break;
                case 3:
                    System.out.println("Enter User ID to Remove:");
                    Long UI = scanner.nextLong();
                    userService.removeUser(UI);
                    System.out.println("User removed successfully!");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}

