package com.example.gisma_accomadation_system.controller;


import com.example.gisma_accomadation_system.model.User;
import com.example.gisma_accomadation_system.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
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
        return new ResponseEntity<>("Users not found", HttpStatus.NOT_FOUND);


    }


    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUser(@PathVariable  Integer userId){
        User user = userService.getUser(userId);

        if(user != null){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        //new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND)
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);

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
    @PostMapping("/auth/login")
    public ResponseEntity<?> loginUser(@RequestBody User user){
        User getUser = userService.findUser(user);
        System.out.println("here ..........");
        if(user.getPassword().equals(getUser.getPassword())){


            Map<String, Object> repsonseBody = new HashMap<>();
             repsonseBody.put("message", "Login successful");
             repsonseBody.put("userId", getUser.getId() + " ");
             repsonseBody.put("userRole", getUser.getRole().name());

//            session.setAttribute("user", getUser); // ✅ Store user in session
             return new ResponseEntity<>(repsonseBody, HttpStatus.OK);

//            return ResponseEntity.ok().headers(headers).body("Login successful");

        } else {
            return new ResponseEntity<>("Invalid password", HttpStatus.UNPROCESSABLE_ENTITY);
        }

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
