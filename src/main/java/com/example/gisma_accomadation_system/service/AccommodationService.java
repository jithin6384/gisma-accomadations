package com.example.gisma_accomadation_system.service;


import com.example.gisma_accomadation_system.model.Accommodation;
import com.example.gisma_accomadation_system.model.User;
import com.example.gisma_accomadation_system.model.Zone;
import com.example.gisma_accomadation_system.repo.AccommodationRepo;
import com.example.gisma_accomadation_system.repo.UserRepo;
import com.example.gisma_accomadation_system.repo.ZoneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccommodationService {

    @Autowired
    private AccommodationRepo accommodationRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ZoneRepo zoneRepo;


    public List<Accommodation> getAllAccommodations() {
        return accommodationRepo.findAll();
    }

    public List<Accommodation> getAccommodationsByZone(int zoneId) {

            Zone zone = zoneRepo.findById(zoneId).orElse(null);
        if(zone != null){

           return  accommodationRepo.findAccommodationsByZone(zoneId);
        }else{
            return null;
        }



    }


        public List<Accommodation> getAccommodationsBySeller(int sellerId) {
            User seller = userRepo.findById(sellerId).orElse(null);
                if(seller != null){
                    return accommodationRepo.findBySeller(sellerId);
            }

                return null;

        }

    public Accommodation createAccommodation(Accommodation accommodation, int sellerId, int zoneId) {
        User seller = userRepo.findById(sellerId).orElse(null);

        Zone zone = zoneRepo.findById(zoneId).orElse(null);

        accommodation.setSeller(seller);
        accommodation.setZone(zone);
        return accommodationRepo.save(accommodation);
    }

    public Accommodation updateAccommodation(int id, Accommodation updatedAccommodation) {
        Accommodation accommodation = accommodationRepo.findById(id).orElse(null);
        if(accommodation != null){
            accommodation.setTitle(updatedAccommodation.getTitle());
            accommodation.setDescription(updatedAccommodation.getDescription());
            accommodation.setPrice(updatedAccommodation.getPrice());
            accommodation.setLocation(updatedAccommodation.getLocation());
            accommodation.setVerified(updatedAccommodation.getVerified());

            return accommodationRepo.save(accommodation);
        }

        return null;

    }

    public void deleteAccommodation(int id) {
        if (!accommodationRepo.existsById(id)) {
            throw new RuntimeException("Accommodation not found");
        }
        accommodationRepo.deleteById(id);
    }
}
