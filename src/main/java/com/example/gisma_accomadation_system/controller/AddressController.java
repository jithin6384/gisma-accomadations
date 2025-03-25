package com.example.gisma_accomadation_system.controller;


import com.example.gisma_accomadation_system.model.Accommodation;
import com.example.gisma_accomadation_system.model.Address;
import com.example.gisma_accomadation_system.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/addresses/{accommodationId}")
    public ResponseEntity<?> getAddress(@PathVariable int accommodationId){
        Address address = addressService.getAddressByAccommodation(accommodationId);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @GetMapping("/address/search")
    public ResponseEntity<List<Integer>> getAccomodationIds(@RequestParam(required = false) String zone, @RequestParam(required = false) String pincode,  @RequestParam(required = false) String price){

        List<Address> results = addressService.searchAddresses(zone, pincode);
        List<Integer> accomodationIds = new ArrayList<>();


        for(Address address: results){
//            if(!accomodationIds.contains(address.getAccommodationId())){
                accomodationIds.add((address.getAccommodationId()));
//            }

        }

        return new ResponseEntity<>(accomodationIds, HttpStatus.OK);
    }

    @PostMapping("/address/{accommodationId}")
    public ResponseEntity<Address> saveAddress(@RequestBody Address address, @PathVariable int accommodationId) {
        return new  ResponseEntity<>(addressService.saveAddress(address, accommodationId), HttpStatus.OK);
    }

    @PutMapping("/addresses/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable String id, @RequestBody Address address) {
        return new ResponseEntity<>(addressService.updateAddress(id, address), HttpStatus.OK);
    }

}
