package com.iacono.app.Movie.App.services;

import com.iacono.app.Movie.App.entities.Genres;
import com.iacono.app.Movie.App.repository.GenresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenresService {
    @Autowired
    private GenresRepository genresRepository;

    public List<Genres> getGenres() {
        List<Genres> genres = genresRepository.findAll();
        return genres;
    }

    public Optional<Genres> getGenre(Long id) {
        Optional<Genres> genres = genresRepository.findById(id);
        return genres;
    }

    public Genres createGenres(Genres genre ) {
        return genresRepository.save(genre);
    }

    public Genres updateGenre(Long id, Genres updatedGenres) {
        Optional<Genres> genres = genresRepository.findById(id);
        if (genres.isPresent()) {
            Genres genre = genres.get();
            genre.setGenre(updatedGenres.getGenre());
            return genresRepository.save(genre);
        } else  throw new RuntimeException("Genere non trovato con id " + id);
    }

    public void deleteGenre(Long id) {
        if (genresRepository.existsById(id)){
            genresRepository.deleteById(id);
        } else {
            throw new RuntimeException("Genere non trovato con id" + id);
        }
    }

}
