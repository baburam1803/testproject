package com.example.cabTracker;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// CabRepository.java
@Repository
public interface CabRepository extends JpaRepository<Cab, Long> {
	Optional<Cab> findByIdAndAvailableDate(Long id, LocalDate availableDate);
}
