package com.iacono.app.Movie.App.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.util.List;

@Entity
@Table
@Data
public class Customers extends Person {
    @Email(message = "l'email deve essere valida")
    private String email;
    @ManyToMany
    private List<Movies> moviesList;



}
