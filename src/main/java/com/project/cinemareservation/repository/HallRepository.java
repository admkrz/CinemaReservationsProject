package com.project.cinemareservation.repository;

import com.project.cinemareservation.model.Hall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HallRepository extends JpaRepository<Hall, Integer> {
}
