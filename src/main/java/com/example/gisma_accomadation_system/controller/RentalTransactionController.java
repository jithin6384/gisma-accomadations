package com.example.gisma_accomadation_system.controller;

import com.example.gisma_accomadation_system.service.RentalTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class RentalTransactionController {
    @Autowired
    RentalTransactionService rentalTransactionService;

    @PostMapping("/{accomodation_id}/{user_id}")
    public void createRentalTransaction(@PathVariable  int accomodation_id, @PathVariable int user_id){
        rentalTransactionService.createRentalTransaction(accomodation_id, user_id);

    }

    @GetMapping("/accommodation/{id}")
    public int getUserCount(@PathVariable int id) {
        return rentalTransactionService.getUserCountForAccommodation(id);
    }

}
