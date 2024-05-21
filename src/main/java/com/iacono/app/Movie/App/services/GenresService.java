package com.iacono.app.Movie.App.services;

import com.iacono.app.Movie.App.entities.Genre;
import com.iacono.app.Movie.App.repository.GenresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenresService {
    @Autowired
    private GenresRepository genresRepository;

    public List<Genre> getGenres() {
        List<Genre> genres = genresRepository.findAll();
        return genres;
    }

    public Optional<Genre> getGenre(Long id) {
        Optional<Genre> genres = genresRepository.findById(id);
        return genres;
    }

    public Genre createGenres(Genre genre ) {
        return genresRepository.save(genre);
    }

    public Genre updateGenre(Long id, Genre updatedGenre) {
        Optional<Genre> genres = genresRepository.findById(id);
        if (genres.isPresent()) {
            Genre genre = genres.get();
            genre.setGenre(updatedGenre.getGenre());
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
