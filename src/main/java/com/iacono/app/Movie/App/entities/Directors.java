package com.iacono.app.Movie.App.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;


@Entity
@Table
@Data
public class Directors extends Person {
    @NotEmpty
    @NotBlank(message = "ruolo richiesto")
    private String role;
}
