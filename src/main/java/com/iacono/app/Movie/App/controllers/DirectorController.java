package com.iacono.app.Movie.App.controllers;

import com.iacono.app.Movie.App.entities.Director;
import com.iacono.app.Movie.App.services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/directors")
public class DirectorController {

    @Autowired
    DirectorService directorService;


//    GET /directors: Recuperare tutti i direttori.
//    GET /directors/{id}: Recuperare i dettagli di un direttore specifico.
//            POST /directors: Aggiungere un nuovo direttore.
//    PUT /directors/{id}: Aggiornare i dettagli di un direttore esistente.
//            DELETE /directors/{id}: Eliminare un direttore.

    @GetMapping()
    public ResponseEntity<List<Director>> getAllDirectors() {
        List<Director> directors = directorService.getAllDirectors();
        return ResponseEntity.ok(directors);
    }

    @GetMapping("/directors/{id}")
    public ResponseEntity<Director> getDirectorById(@PathVariable Long id) {
        Director director = directorService.getDirectorById(id);
        return ResponseEntity.ok(director);
    }

    @PostMapping()
    public ResponseEntity<Director> addDirector(@RequestBody Director director) {
        Director addDirector = directorService.addDirector(director);
        return ResponseEntity.status(201).body(director);
    }

    @PutMapping("/directors/{id}")
    public ResponseEntity <Director> updateDirector (@PathVariable Long id, @RequestBody Director updatedirector) {
        Director director = directorService.updateDirector(id, updatedirector);
        return ResponseEntity.ok(director);
    }

    @DeleteMapping("/directors/{id}")
    public ResponseEntity<Void> deleteDirector(@PathVariable Long id) {
        directorService.deleteDirector(id);
        return ResponseEntity.noContent().build();
    }
}
