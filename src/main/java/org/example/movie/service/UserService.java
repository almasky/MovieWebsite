package org.example.movie.service;

import jakarta.persistence.EntityManager;
import org.example.movie.entity.Genre;
import org.example.movie.entity.UserMovie;
import org.example.movie.repository.AdminRepository;
import org.example.movie.repository.UserRepository;

public class UserService {
    private final UserRepository userRepository = new UserRepository();
    public UserMovie getMovieByTitle(String title) {
        return userRepository.findMovieByTitle(title);
    }
    public UserMovie getMovieByGenre(Genre Genre) {
        return userRepository.findMovieByGenre(Genre);
    }
}
