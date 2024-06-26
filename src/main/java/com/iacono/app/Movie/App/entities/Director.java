package com.iacono.app.Movie.App.entities;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Entity
@Table
@Data
public class Director extends Person  {

    private String name;
    private Date birthDate;
    private String nationality;
    @OneToMany(mappedBy = "director")
    private List<Movie> movieDirected;
}
