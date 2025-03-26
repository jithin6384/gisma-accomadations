package com.example.gisma_accomadation_system.service;

import com.example.gisma_accomadation_system.model.Accommodation;
import com.example.gisma_accomadation_system.model.RentalTransactions;
import com.example.gisma_accomadation_system.model.User;
import com.example.gisma_accomadation_system.repo.AccommodationRepo;
import com.example.gisma_accomadation_system.repo.RentalTransactionRepo;
import com.example.gisma_accomadation_system.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentalTransactionService {

    @Autowired
    RentalTransactionRepo rentalTransactionRepo;

    @Autowired
    AccommodationRepo accommodationRepo;

    @Autowired
    UserRepo userRepo;

    public void createRentalTransaction(int accomodationId, int userId) {
        Accommodation accommodation = accommodationRepo.findById(accomodationId).orElse(null);
        User student =  userRepo.findById(userId).orElse(null);
        if(accommodation != null && student != null){
            RentalTransactions rentalTransactions = new RentalTransactions(accommodation, student);
            accommodation.setStatus("RENTED");
            accommodationRepo.save(accommodation);
            rentalTransactionRepo.save(rentalTransactions);
        }

    }

    public int getUserCountForAccommodation(int id) {
        return rentalTransactionRepo.countUsersByAccommodationId(id);
    }
}
