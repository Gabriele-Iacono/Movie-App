package com.iacono.app.Movie.App.Exceptions;

public class DirectorNotFoundException extends RuntimeException {

    public DirectorNotFoundException(String message) {
        super(message);
    }
}
