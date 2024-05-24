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
//      @Id
//    @GeneratedValue
//    private Long id;
//    @NotEmpty
//    @NotBlank(message = "è richiesto il nome")
//    private String title;
//    @ManyToMany
//    @NotEmpty
//    @NotBlank(message = "inserire almeno un genere")
//    private List<Genre> genres;
//    @ManyToMany
//    @Nullable
//    private List<Customer> customerList;
//    @JsonFormat(pattern = "HH:mm:ss")
//    private LocalTime filmLength;
//    @NotEmpty
//    @NotBlank
//    private Date Year;
//    @ManyToOne
//    @JoinColumn(name = "director_id")
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
    private String title;
    private String description;
    private String releaseDate;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director;

    @ManyToMany
    @JoinTable(
            name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres;

    @ManyToMany
    @JoinTable(
            name = "movie_person",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private List<Person> persons;
}



