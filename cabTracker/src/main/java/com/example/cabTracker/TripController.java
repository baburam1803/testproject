package com.example.cabTracker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//TripController.java
@RestController
@RequestMapping("/api/trips")
public class TripController {
 @Autowired
 private TripService tripService;

 @Autowired
 private UserRepository userRepository; // Add this line
 @Autowired
 private CabRepository cabRepository; // Add this line

 @PostMapping("/book")
 public String bookTrip(@RequestBody TripRequest request) {
     User user = userRepository.findById(request.getUserId())
             .orElseThrow(() -> new RuntimeException("User not found"));
     Cab cab = cabRepository.findById(request.getCabId())
             .orElseThrow(() -> new RuntimeException("Cab not found"));
     return tripService.bookTrip(user, cab,request.getDate());
 }

 @GetMapping("/user/{userId}")
 public List<Trip> getUserTrips(@PathVariable Long userId) {
     return tripService.getUserTrips(userId);
 }
}