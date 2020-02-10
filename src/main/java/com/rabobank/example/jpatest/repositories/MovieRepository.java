package com.rabobank.example.jpatest.repositories;

import com.rabobank.example.jpatest.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
