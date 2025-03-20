package com.example.gisma_accomadation_system.repo;


import com.example.gisma_accomadation_system.model.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepo extends MongoRepository<Address, String> {
    Address findAddressByAccommodationId(int accomId);
 }
