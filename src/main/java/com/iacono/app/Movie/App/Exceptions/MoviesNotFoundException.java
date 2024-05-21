package com.iacono.app.Movie.App.Exceptions;

public class MoviesNotFoundException extends RuntimeException{
    public MoviesNotFoundException(String message) {
        super(message);
    }
}
