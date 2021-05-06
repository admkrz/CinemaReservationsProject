package com.project.cinemareservation.repository;

import com.project.cinemareservation.model.ReservedSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservedSeatRepository extends JpaRepository<ReservedSeat, Integer> {
}
