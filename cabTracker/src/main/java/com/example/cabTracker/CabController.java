package com.example.cabTracker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.Optional;

// CabController.java
@RestController
@RequestMapping("/api/cabs")
public class CabController {
    @Autowired
    private CabService cabService;

    @GetMapping
    public List<Cab> getAllCabs() {
        return cabService.getAllCabs();
    }

    @PostMapping("/add")
    public ResponseEntity<Cab> addCab(@RequestBody Cab cab) {
        cabRepository.save(cab);
        return ResponseEntity.status(HttpStatus.CREATED).body(cab);
    }
    
    @Autowired
    private CabRepository cabRepository;

    @PostMapping("/book")
    public ResponseEntity<String> bookCab(@RequestParam Long cabId, @RequestParam String date) {
        LocalDate bookingDate = LocalDate.parse(date);
        Optional<Cab> cab = cabRepository.findByIdAndAvailableDate(cabId, bookingDate);

        if (cab.isPresent() && cab.get().isAvailable()) {
            Cab bookedCab = cab.get();
            bookedCab.setAvailable(false); // Set cab as unavailable
            //bookedCab.setAvailableDate(null); // Clear availability date
            cabRepository.save(bookedCab);
            return ResponseEntity.ok("Cab booked successfully for " + bookingDate);
        } else {
            return ResponseEntity.status(400).body("Cab not available for booking on " + bookingDate);
        }
    }

    @PutMapping("/{cabId}/setAvailability")
    public ResponseEntity<String> setCabAvailability(@PathVariable Long cabId, @RequestParam String date) {
        Optional<Cab> cab = cabRepository.findById(cabId);

        if (cab.isPresent()) {
            Cab updateCab = cab.get();
            updateCab.setAvailable(true);
            updateCab.setAvailableDate(LocalDate.parse(date));
            cabRepository.save(updateCab);
            return ResponseEntity.ok("Cab availability updated to " + date);
        } else {
            return ResponseEntity.status(404).body("Cab not found.");
        }
    }
}
