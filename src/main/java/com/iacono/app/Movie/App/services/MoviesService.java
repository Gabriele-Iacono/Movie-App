package com.iacono.app.Movie.App.services;

import com.iacono.app.Movie.App.Exceptions.MoviesNotFoundException;
import com.iacono.app.Movie.App.entities.Movie;
import com.iacono.app.Movie.App.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class MoviesService {
    @Autowired
    MoviesRepository moviesRepository;

    public List<Movie> getMovies() {
        List<Movie> movieList = moviesRepository.findAll();
        //! Controlliamo se la lista di film è vuota
        if (movieList == null || movieList.isEmpty()) {
            throw new MoviesNotFoundException("Nessun film trovato");
        }
        return movieList;
    }

    public Movie getMovieById(Long id ) {
        Optional<Movie> movie = moviesRepository.findById(id);
        if (movie.isEmpty()) {
            throw new MoviesNotFoundException("Film non trovato con id: " + id);
        }
        return movie.get();

    }

    public Movie addMovie(Movie movie) {
        return moviesRepository.save(movie);
    }

    public Movie updateMovie(Long id, Movie updatedMovie) {
        Optional<Movie> optionalMovies = moviesRepository.findById(id);

        if (optionalMovies.isEmpty()) {
            throw new MoviesNotFoundException("Film non trovato con id " + id);
        }

        Movie movie = optionalMovies.get();
        movie.setTitle(updatedMovie.getTitle());
        movie.setGenres(updatedMovie.getGenres());
        movie.setYear(updatedMovie.getYear());

        return moviesRepository.save(movie);

    }

    public void deleteMovie(Long id) {
        Optional<Movie> optionalMovie = moviesRepository.findById(id);
        if (optionalMovie.isEmpty()) {
            throw new MoviesNotFoundException("Film non trovato con id " + id);
        }
        moviesRepository.deleteById(id);
    }





























































}
