package com.project.cinemareservation.repository;

import com.project.cinemareservation.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
}
