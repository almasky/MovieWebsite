package org.example.movie.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

@Data
@Entity
@Table(name = "users")
public class AdminMovie {

    public AdminMovie(Long id) {

        this.id = id;
    }

    public AdminMovie() {
    }
    @Setter
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
    @JoinColumn(name = "admin_id")
    private AdminMovie adminMovie;



}