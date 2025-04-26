package org.example.movie.entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class UserMovie {

    public UserMovie(Long id) {

        this.id = id;
    }
    public UserMovie(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }
    public UserMovie() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false,unique = true)
    private String password;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserMovie user;
}