package com.example.cabTracker;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// TripRepository.java
@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

	}