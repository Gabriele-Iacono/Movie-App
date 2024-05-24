package com.iacono.app.Movie.App.services;

import com.iacono.app.Movie.App.Exceptions.DirectorNotFoundException;
import com.iacono.app.Movie.App.Exceptions.GenreNotFoundException;
import com.iacono.app.Movie.App.Exceptions.MoviesNotFoundException;
import com.iacono.app.Movie.App.Exceptions.PersonNotFoundException;
import com.iacono.app.Movie.App.entities.Director;
import com.iacono.app.Movie.App.entities.Genre;
import com.iacono.app.Movie.App.entities.Movie;
import com.iacono.app.Movie.App.entities.Person;
import com.iacono.app.Movie.App.repository.DirectorRepository;
import com.iacono.app.Movie.App.repository.GenresRepository;
import com.iacono.app.Movie.App.repository.MoviesRepository;
import com.iacono.app.Movie.App.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class MoviesService {
    @Autowired
    MoviesRepository moviesRepository;
    @Autowired
    DirectorRepository directorRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    GenresRepository genresRepository;

    public List<Movie> getAllMovies() {
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
        //relazione con i direttore
        if (movie.getDirector() != null) {
            Director director = directorRepository.findById(movie.getDirector().getId())
                    .orElseThrow(() -> new DirectorNotFoundException("Direttore non trovato con id: " + movie.getDirector().getId()));
            movie.setDirector(director);
        }
        //relazione generi
        if (movie.getGenres() != null) {
            List<Genre> genres = movie.getGenres();
            genres.forEach(genre -> genresRepository.findById(genre.getId())
                    .orElseThrow(() -> new GenreNotFoundException("Genere non trovato con id: " + genre.getId())));
            movie.setGenres(genres);
        }
        if (movie.getPersons() != null) {
            List<Person> persons = movie.getPersons();
            persons.forEach(person -> personRepository.findById(person.getId())
                    .orElseThrow(() -> new PersonNotFoundException("Persona non trovata con id: " + person.getId())));
            movie.setPersons(persons);
        }
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
        movie.setReleaseDate(updatedMovie.getReleaseDate());

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
