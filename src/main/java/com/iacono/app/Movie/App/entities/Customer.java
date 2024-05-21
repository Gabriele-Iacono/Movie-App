package com.iacono.app.Movie.App.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.util.List;

@Entity
@Table
@Data
public class Customer extends Person {
    @Email(message = "l'email deve essere valida")
    private String email;
    @ManyToMany
    private List<Movie> movieList;



}
