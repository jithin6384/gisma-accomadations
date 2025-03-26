package com.example.gisma_accomadation_system.repo;

import com.example.gisma_accomadation_system.model.RentalTransactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalTransactionRepo extends JpaRepository<RentalTransactions, Integer> {

    @Query("SELECT COUNT(DISTINCT r.student.id) FROM RentalTransactions r WHERE r.accommodation.id = :accommodationId")
    int countUsersByAccommodationId(@Param("accommodationId") int accommodationId);
}
