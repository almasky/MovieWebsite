package org.example.dto;

public class WatchlistDto {




        private String userId;
        private String userName;
        private List<MovieDTO> movies;

        public WatchlistDTO(String userId, String userName, List<MovieDTO> movies) {
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

        public List<MovieDTO> getMovies() {
            return movies;
        }
    }

}
