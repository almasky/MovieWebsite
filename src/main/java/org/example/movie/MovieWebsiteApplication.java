package org.example.movie;

import org.example.movie.controller.AdminController;
import org.example.movie.controller.MovieController;

public class MovieWebsiteApplication {
    public static void main(String[] args) {

        MovieController movieController = new MovieController();
        movieController.manageMovies();
    }
}
