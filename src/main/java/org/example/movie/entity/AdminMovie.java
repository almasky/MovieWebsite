package org.example.movie.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "admins") // Correctly maps to the "admins" table
public class AdminMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String password;

    // Default constructor
    public AdminMovie() {
    }

    // Parameterized constructor
    public AdminMovie(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }
}