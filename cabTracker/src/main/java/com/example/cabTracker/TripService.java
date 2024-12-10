package com.example.cabTracker;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// TripService.java
@Service
public class TripService {
    @Autowired
    private TripRepository tripRepository;

    public String bookTrip(User user, Cab cab, LocalDate date) {
        // Check if the cab is already booked for the given date
        if (!cab.isAvailable()||!cab.getAvailableDate().equals(date)) {
            return "Cab is not available for the selected date."; // Return error if cab is already booked
        }

        // Proceed with booking if the cab is available
        cab.setAvailable(false);
        Trip newTrip = new Trip();
        newTrip.setUser(user);
        newTrip.setCab(cab);

        tripRepository.save(newTrip); // Save the new trip
        return "Trip booked successfully!";
    }

    public List<Trip> getUserTrips(Long userId) {
        return tripRepository.findAll().stream()
            .filter(trip -> trip.getUser().getId().equals(userId))
            .collect(Collectors.toList());
    }
}