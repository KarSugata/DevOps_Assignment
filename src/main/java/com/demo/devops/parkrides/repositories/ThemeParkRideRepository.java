package com.demo.devops.parkrides.repositories;

import com.demo.devops.parkrides.entities.ThemeParkRide;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeParkRideRepository extends JpaRepository<ThemeParkRide, Long> {
}
