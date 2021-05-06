package com.project.cinemareservation.repository;

import com.project.cinemareservation.model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreeningRepository extends JpaRepository<Screening, Integer> {
}
