package org.example.movie.controller;

import org.example.movie.entity.Movie;
import org.example.movie.entity.Type;
import org.example.movie.entity.Genre;
import org.example.movie.service.MovieService;

import java.util.Scanner;

public class MovieController {

    private final MovieService movieService = new MovieService();

    public void manageMovies() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nContent Management:");
            System.out.println("1. Add Content");
            System.out.println("2. View All Contents");
            System.out.println("3. Find Content by ID");
            System.out.println("4. Remove Content by ID");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter Content Title:");
                    String title = scanner.nextLine();

                    System.out.println("Enter Content Type (MOVIE, SERIES)");
                    String typeInput = scanner.nextLine();
                    Type type = Type.valueOf(typeInput.toUpperCase());

                    System.out.println("Enter Content Genre");
                    String genreInput = scanner.nextLine();
                    Genre genre = Genre.valueOf(genreInput.toUpperCase());

                    Movie newMovie = new Movie(title, type, genre);
                    movieService.addMovie(newMovie);
                    System.out.println("Content added successfully!");
                    break;

                case 2:
                    System.out.println("All Contents:");
                    movieService.getAllMovies().forEach(movie ->
                            System.out.println("ID: " + movie.getId() + ", Title: " + movie.getTitle() +
                                    ", Type: " + movie.getType() + ", Genre: " + movie.getGenre()));
                    break;

                case 3:
                    System.out.println("Enter Movie ID:");
                    Long id = scanner.nextLong();
                    Movie movie = movieService.getMovieById(id);
                    if (movie != null) {
                        System.out.println("Content Details -> ID: " + movie.getId() +
                                ", Title: " + movie.getTitle() +
                                ", Type: " + movie.getType() +
                                ", Genre: " + movie.getGenre());
                    } else {
                        System.out.println("Content not found!");
                    }
                    break;

                case 4:
                    System.out.println("Enter Content ID to Remove:");
                    Long movieId = scanner.nextLong();
                    movieService.deleteMovieById(movieId);
                    System.out.println("Content removed successfully!");
                    break;

                case 5:
                    System.out.println("Exiting Content Management...");
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
