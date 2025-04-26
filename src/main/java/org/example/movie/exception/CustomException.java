package org.example.movie.exception;

public class CustomException extends RuntimeException{

    // Constructor to accept a custom error message
    public CustomException(String message) {
        super(message);
    }

}
