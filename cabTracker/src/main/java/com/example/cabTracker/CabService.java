package com.example.cabTracker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// CabService.java
@Service
public class CabService {
    @Autowired
    private CabRepository cabRepository;

    public List<Cab> getAllCabs() {
        return cabRepository.findAll();
    }

    public Cab addCab(Cab cab) {
        return cabRepository.save(cab);
    }
}