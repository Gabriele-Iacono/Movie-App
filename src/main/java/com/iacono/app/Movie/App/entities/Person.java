package com.iacono.app.Movie.App.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@MappedSuperclass
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    @NotBlank(message = "il nome non può essere vuoto")
    @Size(max = 16, min = 1, message = "il nome deve essere almeno di {min} carattere e massimo di {max} carattere")
    private String firstName;
    @NotEmpty
    @NotBlank(message = "il cognome non può essere vuoto")
    @Size(max = 10, min = 1, message = "il cognome deve essere almeno di {min} carattere e massimo di {max} carattere")
    private String lastName;
    private String role; // es Attore, produttore, Scrittore
    private String birthDate;


}
