package com.iacono.app.Movie.App.services;

import com.iacono.app.Movie.App.Exceptions.PersonNotFoundException;
import com.iacono.app.Movie.App.entities.Person;
import com.iacono.app.Movie.App.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person getPersonById(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isEmpty()) {
            throw new PersonNotFoundException("Persona non trovata con id: " + id);
        }
        return optionalPerson.get();
    }

    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    public Person updatePerson(Long id, Person updatedPerson) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isEmpty()) {
            throw new PersonNotFoundException("Persona non trovata con id: " + id);
        }
        Person person = optionalPerson.get();
        person.setFirstName(updatedPerson.getFirstName());
        person.setRole(updatedPerson.getRole());
        person.setBirthDate(updatedPerson.getBirthDate());
        return personRepository.save(person);
    }

    public void deletePerson(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isEmpty()) {
            throw new PersonNotFoundException("Persona non trovata con id: " + id);
        }
        personRepository.deleteById(id);
    }
}







