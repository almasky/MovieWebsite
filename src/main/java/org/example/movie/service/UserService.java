package org.example.movie.service;


import org.example.movie.entity.AdminMovie;
import org.example.movie.entity.Genre;
import org.example.movie.entity.UserMovie;
import org.example.movie.repository.UserRepository;

import java.util.List;

public class UserService {
    private final UserRepository userRepository = new UserRepository();
    public UserMovie getMovieByTitle(String title) {
        return userRepository.findMovieByTitle(title);
    }
    public UserMovie getMovieByGenre(Genre Genre) {
        return userRepository.findMovieByGenre(Genre);
    }
    public List<UserMovie> getAllUsers() {
        return userRepository.getAllUsers();
    }
    public UserMovie getUserById(Long id) {
        return userRepository.findUserById(id);
    }
    public void addUser(UserMovie admin) {
        userRepository.saveUser(admin);
    }
    public void removeUser(Long id) {
        userRepository.deleteUser(id);
    }
}
