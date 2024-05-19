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
public class Movies {
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    @NotBlank(message = "è richiesto il nome")
    private String name;
    @ManyToMany
    @NotEmpty
    @NotBlank(message = "inserire almeno un genere")
    private List<Genres> genres;
    @ManyToMany
    @Nullable
    private List<Customers> customersList;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime filmLength;
    @NotEmpty
    @NotBlank
    private Date publicationDate;



}
