package com.example.bookinfoservice.controller;
import com.example.bookinfoservice.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.bookinfoservice.repository.*;

import java.util.List;

@CrossOrigin
@RestController
public class LoginController {
    // logging in an employee on the web application
    @Autowired
    UserRepository userRepository;
    @GetMapping("/users/username/{user_name}")
    public User getUserByEmail(@PathVariable String user_name){
        return userRepository.getUserByUserName(user_name);
    }

    @PostMapping("/users/login/")
    @ResponseBody
    public boolean CheckUser(@RequestParam String user_name, String password){

        User user = userRepository.getUserByUserName(user_name);
        if(user.getPassword().equals(password))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Autowired
    EmployeeRepository employeeRepository;
    @GetMapping("/users/id/{id}")
    public List<User> getUserById(@PathVariable Integer id){
        return userRepository.getUserByUserId(id);
    }

    @GetMapping("/employees/username/{user_name}")
    public Employee getEmployeeByUserName(@PathVariable String user_name){
        return employeeRepository.findAllByuserUserName(user_name).stream().findFirst().get();
    }

    @Autowired
    InfluencerRepository influencerRepository;
    @GetMapping("/influencers/username/{user_name}")
    public Influencer getInfluencerByUserName(@PathVariable String user_name){
        return influencerRepository.findAllByuserUserName(user_name).stream().findFirst().get();
    }
}
