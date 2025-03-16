package com.example.gisma_accomadation_system.service;


import com.example.gisma_accomadation_system.model.User;
import com.example.gisma_accomadation_system.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public List<User> getUsers() {
       return userRepo.findAll();
    }

    public User getUser(Integer userId) {
        return userRepo.findById(userId).orElse(null);
    }

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public boolean existsByEmail(String email) {
        return userRepo.findByEmail(email).isPresent();
    }


    public User updateUser(int userId, User updateUser) {

        User user = userRepo.findById(userId).orElse(null);

        if(user != null){
            user.setName(updateUser.getName());
            user.setEmail(updateUser.getEmail());
            user.setRole(updateUser.getRole());


            return userRepo.save(user);
        }

        return null;
    }

    public void deleteUser(int userId) {
        userRepo.deleteById(userId);
    }
}
