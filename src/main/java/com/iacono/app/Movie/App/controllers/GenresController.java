package com.iacono.app.Movie.App.controllers;


import com.iacono.app.Movie.App.entities.Genre;
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
    public ResponseEntity<List<Genre>> getGenres() {
        List<Genre> genres = genresService.getGenres();
        return new ResponseEntity<>(genres, HttpStatus.OK);
    }
//
    @GetMapping("/{id}") // /genres/1
    public ResponseEntity <Optional<Genre>> getGenre  (@PathVariable("id")Long id) {
        Optional<Genre> genres = genresService.getGenre(id);
        if (genres.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(genres, HttpStatus.OK);
    }
//

//
    @PostMapping // Post //genres
    public ResponseEntity<Genre> createGenre(@Valid @RequestBody Genre genre) {
        Genre genres = genresService.createGenres(genre);
        return new ResponseEntity<>(genres, HttpStatus.CREATED);
    }
    //

    //
    @PutMapping("/{id}") // Put //genres/1
    public ResponseEntity<Genre> updateGenres(@PathVariable Long id, @Valid @RequestBody Genre genre) {
        Genre updatedGenre = genresService.updateGenre(id, genre);
        return new ResponseEntity<>(updatedGenre, HttpStatus.OK);
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

