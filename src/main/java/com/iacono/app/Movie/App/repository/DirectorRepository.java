package com.iacono.app.Movie.App.repository;


import com.iacono.app.Movie.App.entities.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository <Director, Long> {
}
