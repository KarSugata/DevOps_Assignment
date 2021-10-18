package com.demo.devops.parkrides.service;

import com.demo.devops.parkrides.entities.ThemeParkRide;
import com.demo.devops.parkrides.repositories.ThemeParkRideRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ThemeParkRideService {
    private final ThemeParkRideRepository themeParkRideRepository;

    public List<ThemeParkRide> getAllRides() {
        return themeParkRideRepository.findAll();
    }

    public Optional<ThemeParkRide> getById(final Long id) {
        return themeParkRideRepository.findById(id);
    }

    public ThemeParkRide save(ThemeParkRide themeParkRide) {
        return themeParkRideRepository.save(themeParkRide);
    }
}
