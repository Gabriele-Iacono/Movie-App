package com.iacono.app.Movie.App.services;

import com.iacono.app.Movie.App.Exceptions.DirectorNotFoundException;
import com.iacono.app.Movie.App.entities.Director;
import com.iacono.app.Movie.App.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorService {

    @Autowired
    DirectorRepository directorRepository;

    public List<Director> getAllDirectors() {
        return directorRepository.findAll();

    }

    public Director getDirectorById(Long id) {
        Optional<Director> optionalDirector = directorRepository.findById(id);
        if (optionalDirector.isEmpty()) {
            throw new DirectorNotFoundException("Direttore non trovato con id: " + id);
        }
        return optionalDirector.get();
    }

    public Director addDirector(Director director) {
        return directorRepository.save(director);

    }

    public Director updateDirector(Long id, Director updatedDirector) {
        Optional<Director> optionalDirector = directorRepository.findById(id);
        if (optionalDirector.isEmpty()) {
            throw new DirectorNotFoundException("Direttore non trovato con id: " + id);
        }
        Director director = optionalDirector.get();
        director.setName(updatedDirector.getName());
        director.setBirthDate(updatedDirector.getBirthDate());
        director.setNationality(updatedDirector.getNationality());
        return directorRepository.save(director);
    }

    public void deleteDirector(Long id) {
        Optional<Director> optionalDirector = directorRepository.findById(id);
        if (optionalDirector.isEmpty()) {
            throw new DirectorNotFoundException("Direttore non trovato con id: " + id);
        }
        directorRepository.deleteById(id);
    }
}
