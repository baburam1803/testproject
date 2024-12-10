package com.example.cabTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// AdminAnalyticsService.java
@Service
public class AdminAnalyticsService {
    @Autowired
    private TripRepository tripRepository;
    private UserRepository userRepository;

    @Autowired
    public AdminAnalyticsService(UserRepository userRepository,TripRepository tripRepository) {
        this.userRepository = userRepository;
        this.tripRepository = tripRepository;  
    }
    public long totalTrips() {
        return tripRepository.count();
    }

    public long totalUsers() {
        return userRepository.count();
    }
}