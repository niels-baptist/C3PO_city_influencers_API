package com.example.bookinfoservice.controller;
import com.example.bookinfoservice.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.bookinfoservice.repository.*;

import java.util.List;

@RestController
public class WitseController {
    @Autowired
    InfluencerRepository influencerRepository;

    @Autowired
    Employee_roleRepository employee_roleRepository;

    @Autowired
    UserRepository userRepository;
    @GetMapping("/Influencers/{influencer_id}")
    public Influencer getLocationById(@PathVariable int influencer_id){
        return influencerRepository.findByInfluencerId(influencer_id);
    }
    @GetMapping("/Influencers")
    public List<Influencer> getInfluencers(){
        return influencerRepository.findAll();
    }
    @GetMapping("/roles/")
    public List<Employee_role> getEmplayee_roles(){
        return employee_roleRepository.findAll();
    }

    @GetMapping("/users/")
    public List<User> getUsers(){
        return userRepository.findAll();
    }
}
