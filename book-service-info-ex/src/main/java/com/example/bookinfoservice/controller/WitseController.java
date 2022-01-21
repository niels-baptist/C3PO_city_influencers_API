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
    @GetMapping("/influencers/")
    public List<Influencer> getInfluencers(){
        return influencerRepository.findAll();
    }

}
