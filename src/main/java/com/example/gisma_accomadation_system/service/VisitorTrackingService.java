package com.example.gisma_accomadation_system.service;

import com.example.gisma_accomadation_system.model.VisitorTracking;
import com.example.gisma_accomadation_system.repo.VisitorTrackingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VisitorTrackingService {
    @Autowired
    private VisitorTrackingRepo visitorTrackingRepo;


    public VisitorTracking getVisitorCount(int accommodationId) {
        return visitorTrackingRepo.findByAccommodationId(accommodationId);
    }

    public VisitorTracking getVisitorTracking(int accommodationId) {
        VisitorTracking visitorTracking = visitorTrackingRepo.findByAccommodationId(accommodationId);

        if (visitorTracking == null) {
            visitorTracking = new VisitorTracking(accommodationId); // Create a new record if not found
            visitorTracking.setVisitorCount(0);
            visitorTracking.setLastVisited(LocalDateTime.now());
        }

        return visitorTracking;
    }

    public VisitorTracking trackVisit(int accommodationId) {
        VisitorTracking visitor =   visitorTrackingRepo.findByAccommodationId(accommodationId);
        if(visitor != null){
            int count = visitor.getVisitorCount();
            count += 1;
            visitor.setVisitorCount(count);
            visitor.setLastVisited(LocalDateTime.now());
        }else{
            visitor = new VisitorTracking(accommodationId);

        }
        visitorTrackingRepo.save(visitor);

        return visitor;
    }
}
