package com.example.gisma_accomadation_system.controller;

import com.example.gisma_accomadation_system.model.Accommodation;
import com.example.gisma_accomadation_system.service.AccommodationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/api/v1/")
public class AccommodationController {

    @Autowired
    AccommodationService accommodationService;

    @GetMapping("/accommodations")
    public ResponseEntity<List<Accommodation>> getAllAccommodations() {
        return new ResponseEntity<>(accommodationService.getAllAccommodations(), HttpStatus.OK);
    }

    @GetMapping("/accommodationsbyId")
    public ResponseEntity<List<Accommodation>> getAccommodationsByIds(@RequestParam(required = false) String ids) {
        System.out.println("String ids " + ids);
        if(ids.isEmpty()){
            return null;
        }
        List<String> idList = new ArrayList<>(List.of(ids.split(",")));

        List<Integer> idLists = new ArrayList<>();
        idList.forEach(id -> idLists.add(Integer.parseInt(id)));;

        return new ResponseEntity<>(accommodationService.getAccommodationsByIds(idLists), HttpStatus.OK);
    }

//    @GetMapping("accommodations/zone/{zoneId}")
//    public ResponseEntity<List<Accommodation>> getAccommodationsByZone(@PathVariable int zoneId) {
//        return new ResponseEntity<>(accommodationService.getAccommodationsByZone(zoneId), HttpStatus.OK);
//    }

    @GetMapping("accommodations/seller/{sellerId}")
    public ResponseEntity<List<Accommodation>> getAccommodationsBySeller(@PathVariable int sellerId) {
        //new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND)
        return new ResponseEntity<>(accommodationService.getAccommodationsBySeller(sellerId), HttpStatus.OK);
    }

    @PostMapping("accommodation/{sellerId}")
    public ResponseEntity<Accommodation> createAccommodation(
            @PathVariable int sellerId,
            @RequestBody Accommodation accommodation) {
        Accommodation newAccommodation = accommodationService.createAccommodation(accommodation, sellerId);
        return new ResponseEntity<>(newAccommodation, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Accommodation> updateAccommodation(
            @PathVariable int id,
            @RequestBody Accommodation updatedAccommodation) {
        return new ResponseEntity<>(accommodationService.updateAccommodation(id, updatedAccommodation), HttpStatus.OK );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAccommodation(@PathVariable int id) {
        accommodationService.deleteAccommodation(id);
        return new ResponseEntity<>("Accommodation deleted successfully.",HttpStatus.OK );
    }


}
