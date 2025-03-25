package com.example.gisma_accomadation_system.service;

import com.example.gisma_accomadation_system.model.Address;
import com.example.gisma_accomadation_system.repo.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    AddressRepo addressRepo;

    public Address getAddressByAccommodation(int accommodationId) {

        return addressRepo.findAddressByAccommodationId(accommodationId);
    }


    public Address saveAddress(Address address, int accommodationId) {
        address.setAccommodationId(accommodationId);
        return addressRepo.save(address);
    }


    public Address updateAddress(String id, Address updatedAddress) {
        Address existingAddress = addressRepo.findById(id).orElse(null);

        existingAddress.setStreet(updatedAddress.getStreet());
        existingAddress.setCity(updatedAddress.getCity());
        existingAddress.setPostalCode(updatedAddress.getPostalCode());
        existingAddress.setZone(updatedAddress.getZone());
        existingAddress.setCountry(updatedAddress.getCountry());

        return addressRepo.save(existingAddress);
    }

    public List<Address> searchAddresses(String zone, String pincode) {
        if (zone != null && pincode != null)
            return addressRepo.findByZoneAndPostalCode(zone, pincode);
        else if (zone != null)
            return addressRepo.findByZone(zone);
        else if (pincode != null)
            return addressRepo.findByPostalCode(pincode);
        else
            return addressRepo.findAll();
    }
}
