package com.example.cabTracker;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// AdminAnalyticsController.java
@RestController
@RequestMapping("/api/admin")
public class AdminAnalyticsController {
    @Autowired
    private AdminAnalyticsService adminAnalyticsService;

    @GetMapping("/analytics")
    public Map<String, Long> getAnalytics() {
        Map<String, Long> analytics = new HashMap<>();
        analytics.put("totalTrips", adminAnalyticsService.totalTrips());
        analytics.put("totalUsers", adminAnalyticsService.totalUsers());
        return analytics;
    }
}