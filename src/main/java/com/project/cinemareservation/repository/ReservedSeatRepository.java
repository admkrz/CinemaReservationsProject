package com.project.cinemareservation.repository;

import com.project.cinemareservation.model.ReservedSeat;
import org.springframework.data.repository.CrudRepository;

public interface ReservedSeatRepository extends CrudRepository<ReservedSeat, Integer> {
}
