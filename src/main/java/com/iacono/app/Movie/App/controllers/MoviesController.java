package com.iacono.app.Movie.App.controllers;


import com.iacono.app.Movie.App.entities.Movie;
import com.iacono.app.Movie.App.services.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {
    // Recupera una lista di tutti i film.
    // GET /movies
    // FATTA


    // GET /movies/{id} fatta
    // Descrizione:   Recupera i dettagli di un film specifico.

    // POST /movies
    // Aggiunge un nuovo film al database.

    // PUT /movies/{id}
    // Aggiorna i dettagli di un film esistente.

    // DELETE /movies/{id}
    // Elimina un film dal database.
    @Autowired
    private MoviesService moviesService;

    //api

    @GetMapping()
    public ResponseEntity<List<Movie>> getallMovies() {
        List<Movie> movies = moviesService.getMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);

    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        Movie movie = moviesService.getMovieById(id);
        return ResponseEntity.ok(movie);

    }

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) throws URISyntaxException {
        Movie newMovie = moviesService.addMovie(movie);
        return ResponseEntity.created(new URI("/movies/" + newMovie.getId())).body(newMovie);
    }

    // dopo le {
// tipo, indice, = , richiami il servizio, proprietà, e in questo caso(@PathVariable, @RequestBody) passi come parametro id, e updatedMovie
    @PutMapping("/movies/{id}")
    public ResponseEntity<Movie> updateMovies(@PathVariable Long id, @RequestBody Movie updatedMovie) {
        Movie updateMovie = moviesService.updateMovie(id, updatedMovie);
        return ResponseEntity.ok(updateMovie);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable Long id) {
     moviesService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }
}
