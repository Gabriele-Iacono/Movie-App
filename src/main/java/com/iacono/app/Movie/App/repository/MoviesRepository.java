package com.iacono.app.Movie.App.repository;

import com.iacono.app.Movie.App.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends JpaRepository <Movie, Long> {
}
