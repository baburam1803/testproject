package com.example.cabTracker;

import java.time.LocalDateTime;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;

// Trip.java
@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Cab cab;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    // Getters and Setters
    public void setUser(User user)
    {
    	this.user=user;
    }
    public void setCab(Cab cab)
    {
    	this.cab=cab;
    }
    public void setStartTime(LocalDateTime startTime)
    {
    	this.startTime=startTime;
    }
    public void setEndTime(LocalDateTime endTime)
    {
    	this.endTime=endTime;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;  // Add this setter to ensure JPA can set the ID when needed
    }
    
    public User getUser()
    {
    	return this.user;
    }
    public Cab getCab()
    {
    	return this.cab;
    }
    public LocalDateTime getStartTime()
    {
    	return this.startTime;
    }
    public LocalDateTime getEndTime()
    {
    	return this.endTime;
    }
}