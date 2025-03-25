package com.example.gisma_accomadation_system.repo;

import com.example.gisma_accomadation_system.model.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccommodationRepo extends JpaRepository<Accommodation, Integer> {
//    @Query(value = "SELECT * FROM accommodations a INNER JOIN zones z ON a.zone_id = z.id WHERE z.id = ?1", nativeQuery = true)
//    List<Accommodation> findAccommodationsByZone(int zoneId);

    @Query(value = "SELECT * FROM accommodations WHERE seller_id = ?1", nativeQuery = true)
    List<Accommodation> findBySeller(int sellerId);

    List<Accommodation> findByIdIn(List<Integer> ids);
}
