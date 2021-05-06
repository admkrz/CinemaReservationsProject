package com.project.cinemareservation.repository;

import com.project.cinemareservation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
