package com.example.bookinfoservice.controller;
import com.example.bookinfoservice.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.bookinfoservice.repository.*;

import java.util.List;

@RestController
public class LoginController {
    // logging in an employee on the web application
    @Autowired
    UserRepository userRepository;
    @GetMapping("/users/username/{user_name}")
    public User getUserByEmail(@PathVariable String user_name){
        return userRepository.getUserByUserName(user_name);
    }

    @GetMapping("/users/id/{id}")
    public List<User> getUserById(@PathVariable Integer id){
        return userRepository.getUserByUserId(id);
    }
}
