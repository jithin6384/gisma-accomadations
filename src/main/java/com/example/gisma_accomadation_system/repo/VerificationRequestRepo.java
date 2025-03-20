package com.example.gisma_accomadation_system.repo;

import com.example.gisma_accomadation_system.model.VerificationRequest;
import com.example.gisma_accomadation_system.model.VerificationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VerificationRequestRepo extends JpaRepository<VerificationRequest, Integer> {
    List<VerificationRequest> findByStatus(VerificationStatus status);
}
