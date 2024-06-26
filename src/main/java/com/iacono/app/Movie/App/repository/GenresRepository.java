package com.iacono.app.Movie.App.repository;

import com.iacono.app.Movie.App.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenresRepository extends JpaRepository <Genre, Long> {

}
