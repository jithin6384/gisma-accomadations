package com.example.gisma_accomadation_system.service;

import com.example.gisma_accomadation_system.model.Accommodation;
import com.example.gisma_accomadation_system.model.User;
import com.example.gisma_accomadation_system.model.VerificationRequest;
import com.example.gisma_accomadation_system.model.VerificationStatus;
import com.example.gisma_accomadation_system.repo.AccommodationRepo;
import com.example.gisma_accomadation_system.repo.UserRepo;
import com.example.gisma_accomadation_system.repo.VerificationRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class VerificationRequestService {
    @Autowired
    private VerificationRequestRepo verificationRequestRepo;

    @Autowired
    private AccommodationRepo accommodationRepo;

    @Autowired
    private UserRepo userRepo;

    // Get all verification requests
    public List<VerificationRequest> getAllRequests() {
        return verificationRequestRepo.findAll();
    }

    // Get requests by status
    public List<VerificationRequest> getRequestsByStatus(VerificationStatus status) {
        return verificationRequestRepo.findByStatus(status);
    }

    // Create a new verification request
    public VerificationRequest createRequest(int accommodationId, int adminId) {
        Accommodation accommodation = accommodationRepo.findById(accommodationId)
                .orElseThrow(() -> new RuntimeException("Accommodation not found"));
        User admin = userRepo.findById(adminId)
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        VerificationRequest request = new VerificationRequest(null, accommodation, admin, VerificationStatus.PENDING);
        return verificationRequestRepo.save(request);
    }

    // Update verification request status
    public VerificationRequest updateRequestStatus(int requestId, VerificationStatus status) {
        VerificationRequest request = verificationRequestRepo.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Verification request not found"));

        request.setStatus(status);
        return verificationRequestRepo.save(request);
    }

}
