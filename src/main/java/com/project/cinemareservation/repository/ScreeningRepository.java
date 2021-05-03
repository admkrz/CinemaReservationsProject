package com.project.cinemareservation.repository;

import com.project.cinemareservation.model.Screening;
import org.springframework.data.repository.CrudRepository;

public interface ScreeningRepository extends CrudRepository<Screening, Integer> {
}
