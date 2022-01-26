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
public class InfluencerController {
    @Autowired
    InfluencerRepository influencerRepository;
    @Autowired
    SocialMediaAccountRepository socialMediaAccountRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    DomainRepository domainRepository;
    @GetMapping("/users")
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    @GetMapping("/influencers/platform/{platform_id}")
    public List<Influencer> getInfluencerByPlatform(@PathVariable Integer platform_id){
        return influencerRepository.findAllByPlatformId(platform_id);
    }
    @GetMapping("/influencers/domain/{domain_id}")
    public List<Influencer> getInfluencerByDomain(@PathVariable Integer domain_id){
        return influencerRepository.findAllByDomainsContaining(domainRepository.findByDomainId(domain_id));
    }

}

