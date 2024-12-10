package com.example.cabTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.cabTracker")  // Ensure this scans your Cab entity class
public class CabTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CabTrackerApplication.class, args);
	}

}
