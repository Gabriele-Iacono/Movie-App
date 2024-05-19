package com.iacono.app.Movie.App.controllers;


import com.iacono.app.Movie.App.entities.Genres;
import com.iacono.app.Movie.App.services.GenresService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/genres")
public class GenresController {

    @Autowired
    private GenresService genresService;

    @GetMapping() // GET /genres
    public ResponseEntity<List<Genres>> getGenres() {
        List<Genres> genres = genresService.getGenres();
        return new ResponseEntity<>(genres, HttpStatus.OK);
    }
//
    @GetMapping("/{id}") // /genres/1
    public ResponseEntity <Optional<Genres>> getGenre  (@PathVariable("id")Long id) {
        Optional<Genres> genres = genresService.getGenre(id);
        if (genres.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(genres, HttpStatus.OK);
    }
//

//
    @PostMapping // Post //genres
    public ResponseEntity<Genres> createGenre(@Valid @RequestBody Genres genre) {
        Genres genres = genresService.createGenres(genre);
        return new ResponseEntity<>(genres, HttpStatus.CREATED);
    }
    //

    //
    @PutMapping("/{id}") // Put //genres/1
    public ResponseEntity<Genres> updateGenres(@PathVariable Long id, @Valid @RequestBody Genres genres) {
        Genres updatedGenres = genresService.updateGenre(id, genres);
        return new ResponseEntity<>(updatedGenres, HttpStatus.OK);
    }
    //

    //
    @DeleteMapping("/{id}") // DELETE  //genres/1
    public ResponseEntity<Void> deleteGenre(@PathVariable Long id) {
        genresService.deleteGenre(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //


    }

