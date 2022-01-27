package com.example.bookinfoservice.controller;
import com.example.bookinfoservice.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.example.bookinfoservice.repository.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

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

    // // login function
    @PostMapping("/users/login")
    public boolean loginUser(@RequestBody String user_username, String user_password) {
        String database_password = userRepository.getUserByUserName(user_username).getPassword();
        return Objects.equals(database_password, user_password);
    }

    @PostMapping("/influencers/login")
    public boolean loginInfluencer(@RequestBody String user_username, String user_password) {
        String database_password = userRepository.getUserByUserName(user_username).getPassword();
        return Objects.equals(database_password, user_password);
    }

    @PostMapping("/employees/login")
    public boolean loginEmployees(@RequestBody String user_username, String user_password) {
        String database_password = userRepository.getUserByUserName(user_username).getPassword();
        return Objects.equals(database_password, user_password);
    }



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

    // // Employee CRUD

    @PostMapping(value = "/employees/register", consumes =MediaType.APPLICATION_JSON_VALUE ,
            headers = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeRepository.save(new Employee(employee.getEmployee_role(),employee.getUser()));
    }



}
