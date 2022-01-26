package com.example.bookinfoservice.controller;
import com.example.bookinfoservice.model.*;
import com.example.bookinfoservice.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class LocationController  {
    //location
    @Autowired
    LocationRepository locationRepository;
    @GetMapping("/locations")
    public List<Location> getAllLocations(){
        return locationRepository.findAll();
    }

    //Employee
    /*@Autowired
    EmployeeRepository employeeRepository;
    @GetMapping("/employees/")
    public List<Employee> getAllEmployees(){return employeeRepository.findAll();
    }*/

    //Campaign
    @Autowired
    CampaignRepository campaignRepository;
    @GetMapping("/campaigns")
    public List<Campaign> getAllCampaigns(){return campaignRepository.findAll();
    }

    //Campaign Status
    @Autowired
    CampaignStatusRepository campaignStatusRepository;
    @GetMapping("/campaignstatuses")
    public List<CampaignStatus> getAllCampaignStatuses(){return campaignStatusRepository.findAll();
    }



    //Social Media Account
    @Autowired
    SocialMediaAccountRepository socialMediaAccountRepository;
    @GetMapping("/accounts")
    public List<SocialMediaAccount> getAllSocialMediaAccounts(){return socialMediaAccountRepository.findAll();
    }

    //Social Media Platform
    @Autowired
    SocialMediaPlatformRepository socialMediaPlatformRepository;
    @GetMapping("/platforms")
    public List<SocialMediaPlatform> getAllsocialMediaPlatforms(){return socialMediaPlatformRepository.findAll();
    }

    // Submission
    @Autowired
    SubmissionRepository submissionRepository;
    @GetMapping("/submissions")
    public List<Submission> getAllSubmissions(){return submissionRepository.findAll();
    }

    // Submission status
    @Autowired
    SubmissionStatusRepository submissionStatusRepository;
    @GetMapping("/submissionStatuses")
    public List<SubmissionStatus> getAllSubmissionStatuses(){return submissionStatusRepository.findAll();
    }

 }

