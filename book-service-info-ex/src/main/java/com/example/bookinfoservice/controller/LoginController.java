package com.example.bookinfoservice.controller;
import com.example.bookinfoservice.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.example.bookinfoservice.repository.*;

import java.util.List;

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
    @GetMapping("/users/username/{user_name}")
    public User getUserByEmail(@PathVariable String user_name){
        return userRepository.getUserByUserName(user_name);
    }

    @GetMapping("/users/id/{id}")
    public List<User> getUserById(@PathVariable Integer id){
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
        return userRepository.save(user);
    }
    @PostMapping("/influencers/register")
    public Influencer addInfluencer(@RequestBody Influencer influencer){
        return influencerRepository.save(influencer);
    }
    @RequestMapping(value = "/employees/register", method = RequestMethod.POST,consumes =MediaType.APPLICATION_JSON_VALUE ,
            headers = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }
}
