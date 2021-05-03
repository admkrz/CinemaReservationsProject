package com.project.cinemareservation.repository;

import com.project.cinemareservation.model.Seat;
import org.springframework.data.repository.CrudRepository;

public interface SeatRepository extends CrudRepository<Seat, Integer> {
}
