package org.example.movie.exception;

import org.hibernate.HibernateException;

public class GlobalExceptionHandler {

    // Method to handle exceptions
    public static void handle(Exception e) {
        if (e instanceof CustomException) {
            // Handles Custom Exceptions
            System.err.println("Custom Error: " + e.getMessage());
        } else if (e instanceof HibernateException) {
            // Handles Hibernate-specific exceptions
            System.err.println("Database Error: Please check your database connection or queries.");
        } else {
            // Handles general exceptions
            System.err.println("Unexpected Error: " + e.getMessage());
        }
    }
}