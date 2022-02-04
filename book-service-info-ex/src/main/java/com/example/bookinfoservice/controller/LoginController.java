package com.example.bookinfoservice.controller;
import com.example.bookinfoservice.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.example.bookinfoservice.repository.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
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
    @GetMapping("/users/login/{user_username}/{user_password}")
    @ResponseBody
    public boolean loginUser(@PathVariable Map<String, String> json) {
        String database_password = userRepository.findFirstByUserName(json.get("user_username")).getPassword();
        return Objects.equals(database_password, json.get("user_password"));
    }

    @PostMapping("/influencers/login")
    @ResponseBody
    public boolean loginInfluencer(@RequestBody Map<String, String> json) {
        String database_password = userRepository.findFirstByUserName(json.get("user_username")).getPassword();
        return Objects.equals(database_password, json.get("user_password"));
    }

    @RequestMapping(value = "/employees/login", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public boolean loginEmployees(@PathVariable("user_username") String user_username, String user_password) {
        String database_password = userRepository.getUserByUserName(user_username).getPassword();
        return Objects.equals(database_password, user_password);
    }

    @RequestMapping(value = "/employees/login/returnsId", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Employee loginEmployeesWithReturn(@PathVariable("user_username") String user_username, String user_password) {
        User user = userRepository.getUserByUserName(user_username);
        String database_password = user.getPassword();
        if(Objects.equals(database_password, user_password)){
            return employeeRepository.findByUserEquals(user);
        }else{
            return null;
        }
    }



    @GetMapping("/users/username/{user_name}")
    public User getUserByEmail(@PathVariable String user_name){
        return userRepository.getUserByUserName(user_name);
    }


    @GetMapping("/employees/username/{user_name}")
    public Employee getEmployeeByUserName(@PathVariable String user_name){
        return employeeRepository.findAllByuserUserName(user_name).stream().findFirst().get();
    }





}
