package com.project.cinemareservation.repository;

import com.project.cinemareservation.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Integer> {
}
