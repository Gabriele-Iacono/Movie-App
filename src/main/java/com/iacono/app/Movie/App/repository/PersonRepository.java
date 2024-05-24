package com.iacono.app.Movie.App.repository;

import com.iacono.app.Movie.App.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository <Person, Long>  {

}
