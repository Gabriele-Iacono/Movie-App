package com.iacono.app.Movie.App.controllers;

import com.iacono.app.Movie.App.entities.Person;
import com.iacono.app.Movie.App.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("persons")
public class PersonController {
    //    GET /persons: Recuperare tutti i persons
//    GET /persons/{id}: Recuperare i dettagli di un persons specifico.
//            POST /persons: Aggiungere un nuovo persons.
//    PUT /persons/{id}: Aggiornare i dettagli di un persons esistente.
//            DELETE /persons/{id}: Eliminare un persons.
    @Autowired
    PersonService personService;

    @GetMapping

    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> persons = personService.getAllPersons();
        return ResponseEntity.ok(persons);
    }

    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        Person person = personService.getPersonById(id);
        return ResponseEntity.ok(person);
    }

    @PostMapping
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        Person newPerson = personService.addPerson(person);
        return ResponseEntity.status(201).body(newPerson);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person updatedPerson) {
        Person person = personService.updatePerson(id, updatedPerson);
        return ResponseEntity.ok(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }
}




