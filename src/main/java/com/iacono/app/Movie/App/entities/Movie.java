package com.iacono.app.Movie.App.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
public class Movie {
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    @NotBlank(message = "è richiesto il nome")
    private String title;
    @ManyToMany
    @NotEmpty
    @NotBlank(message = "inserire almeno un genere")
    private List<Genre> genres;
    @ManyToMany
    @Nullable
    private List<Customer> customerList;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime filmLength;
    @NotEmpty
    @NotBlank
    private Date Year;
    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director;


    // Recupera una lista di tutti i film.
    // GET /movies


    // GET /movies/{id}
    // Descrizione: Recupera i dettagli di un film specifico.

    // POST /movies
    // Aggiunge un nuovo film al database.

    // PUT /movies/{id}
    // Aggiorna i dettagli di un film esistente.

    // DELETE /movies/{id}
    // Elimina un film dal database.




}
