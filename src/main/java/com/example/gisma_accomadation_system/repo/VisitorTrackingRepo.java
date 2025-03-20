package com.example.gisma_accomadation_system.repo;

import com.example.gisma_accomadation_system.model.VisitorTracking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorTrackingRepo extends MongoRepository<VisitorTracking, String> {
     VisitorTracking findByAccommodationId(int accommodationId);

}
