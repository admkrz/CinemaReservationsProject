package com.project.cinemareservation.repository;

import com.project.cinemareservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
