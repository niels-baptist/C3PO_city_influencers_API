package com.example.bookinfoservice.controller;
import com.example.bookinfoservice.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.example.bookinfoservice.repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    // // User CRUD

    @GetMapping(value = "/users", produces = "application/json")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping(value = "/users/{user_id}", produces = "application/json")
    public User getUserById(@PathVariable int user_id){
        return userRepository.getUserByUserId(user_id);
    }

    @PostMapping("/users/register")
    public User registerUser(@RequestBody User user){
        return userRepository.save(new User(user.getLocation(), user.getEmail(),user.getPassword(), user.getFirstname(), user.getLastname(), user.getUserName(), user.getBirthdate()));
    }
    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        return userRepository.save(new User(user.getLocation(), user.getEmail(),user.getPassword(), user.getFirstname(), user.getLastname(), user.getUserName(), user.getBirthdate()));
    }
    @PutMapping(value= "/users" )
    public User updateUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @DeleteMapping("/users/{user_id}")
    public void deleteUser(@PathVariable int user_id){
        userRepository.deleteById(user_id);
    }

}
