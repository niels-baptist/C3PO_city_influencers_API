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
public class SharedController  {

    // domains
    @Autowired
    LocationRepository locationRepository;
    @GetMapping("/domains")
    public List<Domain> getDomains(){
        return domainRepository.findAll();
    }

    // locations
    @Autowired
    DomainRepository domainRepository;
    @GetMapping("/locations")
    public List<Location> getLocations(){
        return locationRepository.findAll();
    }

    //Social Media Platform
    @Autowired
    SocialMediaPlatformRepository socialMediaPlatformRepository;
    @GetMapping("/platforms")
    public List<SocialMediaPlatform> getSocialMediaPlatforms(){return socialMediaPlatformRepository.findAll();
    }

    // Submission status
    @Autowired
    SubmissionStatusRepository submissionStatusRepository;
    @GetMapping("/submissionStatuses")
    public List<SubmissionStatus> getSubmissionStatuses(){return submissionStatusRepository.findAll();
    }

    //Campaign Status
    @Autowired
    CampaignStatusRepository campaignStatusRepository;
    @GetMapping("/campaignstatuses")
    public List<CampaignStatus> getAllCampaignStatuses(){return campaignStatusRepository.findAll();
    }
}
