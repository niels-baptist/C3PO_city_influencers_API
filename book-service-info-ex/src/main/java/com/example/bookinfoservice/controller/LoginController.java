package com.example.bookinfoservice.controller;
import com.example.bookinfoservice.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.example.bookinfoservice.repository.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@CrossOrigin
@RestController
public class LoginController {
    // logging in an employee on the web application
    @Autowired
    UserRepository userRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    InfluencerRepository influencerRepository;

    @Autowired
    LocationRepository locationRepository;

    @GetMapping("/users/username/{user_name}")
    public User getUserByEmail(@PathVariable String user_name){
        return userRepository.getUserByUserName(user_name);
    }

    @GetMapping("/users/id/{id}")
    public User getUserById(@PathVariable Integer id){
        return userRepository.getUserByUserId(id);
    }

    @GetMapping("/employees/username/{user_name}")
    public Employee getEmployeeByUserName(@PathVariable String user_name){
        return employeeRepository.findAllByuserUserName(user_name).stream().findFirst().get();
    }

    @GetMapping("/influencers/username/{user_name}")
    public Influencer getInfluencerByUserName(@PathVariable String user_name){
        return influencerRepository.findAllByuserUserName(user_name).stream().findFirst().get();
    }
    @PostMapping("/users/register")
    public User addUser(@RequestBody User user){
        return userRepository.save(new User(user.getLocation(), user.getEmail(),user.getPassword(), user.getFirstname(), user.getLastname(), user.getUserName(), user.getBirthdate()));
    }

    @PostMapping("/influencers/register")
    public Influencer addInfluencer(@RequestBody Influencer influencer){
        return influencerRepository.save(new Influencer(influencer.getUser(),influencer.getGender()));
    }
    @PostMapping(value = "/employees/register", consumes =MediaType.APPLICATION_JSON_VALUE ,
            headers = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeRepository.save(new Employee(employee.getEmployee_role(),employee.getUser()));
    }



}
