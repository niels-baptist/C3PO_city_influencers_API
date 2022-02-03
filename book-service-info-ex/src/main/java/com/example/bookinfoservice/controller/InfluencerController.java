package com.example.bookinfoservice.controller;
import com.example.bookinfoservice.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.bookinfoservice.repository.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
        List<Influencer> influencers = influencerRepository.findAll();
        influencers.sort(Comparator.comparing(i -> i.getUser().getFirstname()));
        return influencers;
    }

    @CrossOrigin()
    @GetMapping(value ="/influencers/{influencer_id}", produces = "application/json")
    public Influencer getInfluencerByInfluencerId(@PathVariable Integer influencer_id){
        return influencerRepository.findByInfluencerId(influencer_id);
    }

    @PostMapping("/influencers/register")
    public Influencer registerInfluencer(@RequestBody Influencer influencer){
        return influencerRepository.save(new Influencer(influencer.getPictureUrl(),influencer.getGender(),influencer.getUser(),influencer.getDomains()));
    }
    @PostMapping("/influencers")
    public Influencer addInfluencer(@RequestBody Influencer influencer){
        return influencerRepository.save(new Influencer(influencer.getPictureUrl(),influencer.getGender(),influencer.getUser(),influencer.getDomains()));
    }

    @PutMapping("/influencers")
    public Influencer updateInfluencer(@RequestBody Influencer influencer){
        // automaticaly saves the user as well
        influencer.setUser(userRepository.save(influencer.getUser()));
        return influencerRepository.save(influencer);
    }

    @DeleteMapping("/influencers/{influencer_id}")
    public void deleteInfluencer(@PathVariable Integer influencer_id){
        influencerRepository.deleteById(influencer_id);
    }

    // // SocialMediaAccount CRUD

    @CrossOrigin()
    @GetMapping(value ="/accounts/{influencer_id}", produces = "application/json")
    public List<SocialMediaAccount> getSocialMediaAccounts(@PathVariable int influencer_id){
        return socialMediaAccountRepository.findAllByInfluencerId(influencer_id);
    }

    @PostMapping(value ="/accounts", produces = "application/json")
    @ResponseBody
    public SocialMediaAccount addSocialMediaAccount(@RequestBody SocialMediaAccount socialMediaAccount){
        return socialMediaAccountRepository.save(new SocialMediaAccount(socialMediaAccount.getInfluencerId(),socialMediaAccount.getPlatform(),socialMediaAccount.getName(),socialMediaAccount.getUrl()));
    }

    @PutMapping(value ="/accounts", produces = "application/json")
    @ResponseBody
    public SocialMediaAccount updateSocialMediaAccount(@RequestBody SocialMediaAccount socialMediaAccount){
        return socialMediaAccountRepository.save(socialMediaAccount);
    }

    @CrossOrigin()
    @DeleteMapping(value ="/accounts/{account_id}", produces = "application/json")
    public void deleteSocialMediaAccount(@PathVariable int account_id){
        socialMediaAccountRepository.deleteById(account_id);
    }


    // complexer get functions

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
    @CrossOrigin()
    @GetMapping(value ="/influencers/campaign/{campaign_id}", produces = "application/json")
    public List<Influencer> getInfluencerByCampaign(@PathVariable Integer campaign_id){
        return influencerRepository.findAllByCampaign(campaign_id);
    }

}

