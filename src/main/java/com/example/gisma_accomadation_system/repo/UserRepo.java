package com.example.gisma_accomadation_system.repo;

import com.example.gisma_accomadation_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {


    User findByEmail(String email);
}
