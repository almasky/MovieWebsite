package org.example.movie.dto;

import java.util.List;

public class WatchlistDto {

        private String userId;
        private String userName;
        private List<MovieDto> movies;

        public WatchlistDto(String userId, String userName, List<MovieDto> movies) {
            this.userId = userId;
            this.userName = userName;
            this.movies = movies;
        }

        public String getUserId() {
            return userId;
        }

        public String getUserName() {
            return userName;
        }

        public List<MovieDto> getMovies() {
            return movies;
        }
    }












