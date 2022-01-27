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

    // // influencer CRUD
    @CrossOrigin()
    @GetMapping(value ="/influencers", produces = "application/json")
    public List<Influencer> getInfluencers(){
        return influencerRepository.findAll();
    }

    @CrossOrigin()
    @GetMapping(value ="/influencers/{influencer_id}", produces = "application/json")
    public Influencer getInfluencerByInfluencerId(@PathVariable Integer influencer_id){
        return influencerRepository.findByInfluencerId(influencer_id);
    }

    @PostMapping("/influencers/register")
    public Influencer registerInfluencer(@RequestBody Influencer influencer){
        return influencerRepository.save(new Influencer(influencer.getUser(),influencer.getGender(),influencer.getDomains()));
    }
    @PostMapping("/influencers")
    public Influencer addInfluencer(@RequestBody Influencer influencer){
        return influencerRepository.save(new Influencer(influencer.getUser(),influencer.getGender(),influencer.getDomains()));
    }

    @PutMapping("/influencers")
    public Influencer updateInfluencer(@RequestBody Influencer influencer){
        return influencerRepository.save(influencer);
    }

    @DeleteMapping("/influencers/{influencer_id}")
    public void deleteInfluencer(@PathVariable Integer influencer_id){
        influencerRepository.deleteById(influencer_id);
    }





    @GetMapping("/influencers/platform/{platform_id}")
    public List<Influencer> getInfluencerByPlatform(@PathVariable Integer platform_id){
        return influencerRepository.findAllByPlatformId(platform_id);
    }
    @GetMapping("/influencers/domain/{domain_id}")
    public List<Influencer> getInfluencerByDomain(@PathVariable Integer domain_id){
        return influencerRepository.findAllByDomainsContaining(domainRepository.findByDomainId(domain_id));
    }

    @GetMapping("/influencers/username/{user_name}")
    public Influencer getInfluencerByUserName(@PathVariable String user_name){
        return influencerRepository.findAllByuserUserName(user_name).stream().findFirst().get();
    }

    @PostMapping("/influencers/addDomain")
    public Influencer addDomains(@RequestBody Influencer influencer){
        return influencerRepository.save(new Influencer(influencer.getUser(),influencer.getGender()));
    }

}

