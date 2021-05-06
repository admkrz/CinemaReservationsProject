package com.project.cinemareservation.repository;

import com.project.cinemareservation.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
