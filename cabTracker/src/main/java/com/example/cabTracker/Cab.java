package com.example.cabTracker;

import jakarta.persistence.Id;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

// Cab.java
@Entity
public class Cab {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String driverName;
    private String licensePlate;
    private boolean available; // Indicates if the cab is currently available
    private LocalDate availableDate; // Indicates when the cab is available

    // Getters and Setters
    public void setCab(Cab cab)
    {
    	this.driverName=cab.driverName;
    	this.licensePlate=cab.licensePlate;
    }
    
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;  // Add this setter to ensure JPA can set the ID when needed
    }
    
    public void setDriverName(String driverName)
    {
    	this.driverName=driverName;
    }
    public void setLicensePlate(String licensePlate)
    {
    	this.licensePlate=licensePlate;
    }
    public String getDriverName()
    {
    	return this.driverName;
    }
    public String getLicensePlate()
    {
    	return this.licensePlate;
    }

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public LocalDate getAvailableDate() {
		return availableDate;
	}

	public void setAvailableDate(LocalDate availableDate) {
		this.availableDate = availableDate;
	}
}

