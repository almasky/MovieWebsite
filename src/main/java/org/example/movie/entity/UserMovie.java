package org.example.movie.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserMovie {

    public UserMovie(Long id) {

        this.id = id;
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

    public void setId(Long id) {

        this.id = id;
    }
    public String getEmail() {

        return email;
    }
    public void setEmail(String email) {

        this.email = email;
    }
    public String getUsername() {

        return username;
    }
    public void setUsername(String username) {

        this.username = username;
    }
    public String getPassword() {

        return password;
    }
    public void setPassword(String password) {

        this.password = password;
    }
}