package com.example.gisma_accomadation_system.controller;


import com.example.gisma_accomadation_system.model.Address;
import com.example.gisma_accomadation_system.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/address/{accommodationId}")
    public ResponseEntity<Address> saveAddress(@RequestBody Address address, @PathVariable int accommodationId) {
        return new  ResponseEntity<>(addressService.saveAddress(address, accommodationId), HttpStatus.OK);
    }

    @PutMapping("/addresses/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable String id, @RequestBody Address address) {
        return new ResponseEntity<>(addressService.updateAddress(id, address), HttpStatus.OK);
    }

}
