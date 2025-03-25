package com.example.gisma_accomadation_system.controller;
import com.example.gisma_accomadation_system.model.Accommodation;
import com.example.gisma_accomadation_system.model.VerificationRequest;
import com.example.gisma_accomadation_system.model.VerificationStatus;
import com.example.gisma_accomadation_system.service.AccommodationService;
import com.example.gisma_accomadation_system.service.VerificationRequestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1")
public class VerificationRequestController {

    @Autowired
    VerificationRequestService verificationRequestService;


    @GetMapping("/verification-requests")
    public ResponseEntity<List<VerificationRequest>> getAllRequests() {
        return new ResponseEntity<>((verificationRequestService.getAllRequests()), HttpStatus.OK);
    }

    @GetMapping("/verification-request/status/{status}")
    public ResponseEntity<List<VerificationRequest>> getRequestsByStatus(@PathVariable VerificationStatus status) {
        return new ResponseEntity<>((verificationRequestService.getRequestsByStatus(status)),HttpStatus.OK);
    }

    //check these two methods
    @PostMapping("/verification-request/{accommodationId}/{sellerId}")
    public ResponseEntity<VerificationRequest> createVerificationRequest(@PathVariable int accommodationId, @PathVariable int sellerId) {
        VerificationRequest request = verificationRequestService.createRequest(accommodationId, sellerId);
        return ResponseEntity.status(201).body(request);
    }

    @PutMapping("/verification-request/{requestId}/{status}")
    public ResponseEntity<VerificationRequest> updateVerificationStatus(@PathVariable int requestId, @PathVariable VerificationStatus status) {
        VerificationRequest updatedRequest = verificationRequestService.updateRequestStatus(requestId, status);
        return ResponseEntity.ok(updatedRequest);
    }

    @DeleteMapping("/verification-request/{id}")
    public ResponseEntity<?> deleteVerificationRequest(@PathVariable int id) {
        verificationRequestService.deleteVerificationRequest(id);
        return new ResponseEntity<>("verification Request  deleted successfully.",HttpStatus.OK );
    }

}