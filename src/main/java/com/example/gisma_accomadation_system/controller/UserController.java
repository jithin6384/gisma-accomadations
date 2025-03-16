package com.example.gisma_accomadation_system.controller;


import com.example.gisma_accomadation_system.model.User;
import com.example.gisma_accomadation_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ResponseEntity<?>  getUsers(){
        List<User> users = userService.getUsers();
        System.out.println("user size is " + users.size());
        System.out.println("http status " + HttpStatus.OK.getClass().getName());
        //new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);

        if(users.size() > 0 ){
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Users not found.");


    }


    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUser(@PathVariable  Integer userId){
        User user = userService.getUser(userId);

        if(user != null){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }

        return new ResponseEntity<>(new User(), HttpStatus.NOT_FOUND);

    }

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody User user){
//         userService.createUser(user);
        try{
            if (userService.existsByEmail(user.getEmail())) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("User with this email already exists.");
            }
            User newUser = userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
        } catch(Exception e){
            System.out.println(e.getStackTrace());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

//         return new ResponseEntity<>(userService.getUser(user.getId()), HttpStatus.OK);
    }

    @PutMapping("/user/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable int userId, @RequestBody User user){
        try{
            User updateduser = userService.updateUser(userId, user);
            if(updateduser == null){
                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("user/{userId}")
     public ResponseEntity<String> deleteUser(@PathVariable int userId){
        try{
            User user = userService.getUser(userId);
            if(user != null){
                userService.deleteUser(userId);
                return new ResponseEntity<>("Deleted User", HttpStatus.OK);
            }
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
