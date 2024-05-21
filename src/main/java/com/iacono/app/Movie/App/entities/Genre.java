package com.iacono.app.Movie.App.entities;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Entity
@Table
@Data
public class Genre {
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    @NotBlank(message = "genere richiesto")
    private String genre;
    @ManyToMany
    @Nullable
    private List<Movie> movieList;

}
