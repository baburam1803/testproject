package com.example.cabTracker;

import java.time.LocalDate;

//TripRequest.java
public class TripRequest {
 private Long userId;
 private Long cabId;
 private LocalDate date;

 // Getters and Setters
 public Long getUserId() {
     return userId;
 }

 public void setUserId(Long userId) {
     this.userId = userId;
 }

 public Long getCabId() {
     return cabId;
 }

 public void setCabId(Long cabId) {
     this.cabId = cabId;
 }

public LocalDate getDate() {
	return date;
}

public void setDate(LocalDate date) {
	this.date = date;
}
}