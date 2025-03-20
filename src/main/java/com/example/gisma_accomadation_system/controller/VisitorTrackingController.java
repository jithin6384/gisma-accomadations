package com.example.gisma_accomadation_system.controller;


import com.example.gisma_accomadation_system.model.VisitorTracking;
import com.example.gisma_accomadation_system.repo.VisitorTrackingRepo;
import com.example.gisma_accomadation_system.service.VisitorTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class VisitorTrackingController {

    @Autowired
    VisitorTrackingService visitorTrackingService;

    @GetMapping("/visitors/{accommodationId}")
    public ResponseEntity<VisitorTracking> getVisitorCount(@PathVariable int accommodationId) {
        return new ResponseEntity<>(visitorTrackingService.getVisitorCount(accommodationId), HttpStatus.OK);
    }

    @PostMapping("/visitor/{accommodationId}")
    public ResponseEntity<VisitorTracking> trackVisit(@PathVariable int accommodationId, @RequestBody VisitorTracking visitorTracking) {
        return ResponseEntity.ok(visitorTrackingService.trackVisit(accommodationId));
    }

}
