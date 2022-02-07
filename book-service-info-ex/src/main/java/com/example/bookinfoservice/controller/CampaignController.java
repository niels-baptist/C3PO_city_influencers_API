package com.example.bookinfoservice.controller;
import com.example.bookinfoservice.Form.CampaignForm;
import com.example.bookinfoservice.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.bookinfoservice.repository.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
public class CampaignController  {

    // campaign statusId: 1: saved , 2: open, 3: in afwachting van goedkeuring, 4: afgerond

    @Autowired
    InfluencerRepository influencerRepository;
    @Autowired
    CampaignRepository campaignRepository;
    // Get all campaigns on submissions with specified influencerId
    @Autowired
    SubmissionRepository submissionRepository;

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DomainRepository domainRepository;
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    CampaignStatusRepository campaignStatusRepository;
    @Autowired
    SocialMediaPlatformRepository socialMediaPlatformRepository;


    @GetMapping(value = "/campaigns", produces = "application/json")
    public List<Campaign> getCampaigns(){
        return campaignRepository.findAll();
    }

    @GetMapping(value = "/campaigns/{campaign_id}", produces = "application/json")
    public Campaign getCampaignByCampaignId(@PathVariable Integer campaign_id){
        return campaignRepository.findByCampaignId(campaign_id);
    }
    @GetMapping("/campaigns/influencer/{influencer_id}")
    public List<Campaign> getCampaignsByInfluencer(@PathVariable Integer influencer_id){
        // // This call to the data base works better with lambda functions due to the amount of association tables that would be joined in native sql
        return getOpenCampaignsByDomains(influencer_id);
    }


    @GetMapping("/campaigns/recomended/{influencer_id}")
    public List<Campaign> getRecomendedCampaignsByInfluencerId(@PathVariable Integer influencer_id){
        return campaignRepository.findAllByStatusIdAndInfluencerId(1,influencer_id,2);

    }

    @GetMapping("/campaigns/open/{influencer_id}")
    public List<Campaign> getOpenCampaignsByDomains(@PathVariable Integer influencer_id){
        // // This call to the data base works better with lambda functions due to the amount of association tables that would be joined in native sql
        Set<Domain> domains = influencerRepository.findByInfluencerId(influencer_id).getDomains();
        List<Campaign> campaigns = domains.stream().map(d -> campaignRepository.findAllByStatusAndDomain(d.getDomainId(),2)).flatMap(List::stream).collect(Collectors.toList());
        return campaigns;
    }

    @PostMapping("/campaigns")
    public Campaign addCampaign(@RequestBody Campaign campaign){
        return campaignRepository.save(new Campaign(campaign.getEmployee(), campaign.getName(), campaign.getDescription(), campaign.getFotoUrl(),campaign.getStartDate(),campaign.getEndDate(), campaign.getLocation(), campaign.getCampaignStatus(),campaign.getDomain(), campaign.getSocialMediaPlatform()));
    }

    @PostMapping("/campaigns/campaignForm")
    public Campaign addCampaignForm(@RequestBody CampaignForm campaignForm){
        Employee employee = employeeRepository.findByEmployeeId(campaignForm.getEmployeeId());
        Location location = locationRepository.findByLocationId(campaignForm.getLocationId());
        CampaignStatus status = campaignStatusRepository.findByStatusId(campaignForm.getCampaignStatusId());
        Domain domain = domainRepository.findByDomainId(campaignForm.getDomainId());
        SocialMediaPlatform socialMediaPlatform = socialMediaPlatformRepository.findById(campaignForm.getPlatformId()).get();;
        Campaign campaign = campaignForm.createCampaign(employee,location,status,domain,socialMediaPlatform);
        return campaignRepository.save(campaign);
    }

    @PutMapping("/campaigns")
    public Campaign updateCampaign(@RequestBody Campaign campaign){
        return campaignRepository.save(campaign);
    }

    @PutMapping("/campaigns/campaignForm")
    public Campaign updateCampaign(@RequestBody CampaignForm campaignForm){
        Employee employee = employeeRepository.findByEmployeeId(campaignForm.getEmployeeId());
        Location location = locationRepository.findByLocationId(campaignForm.getLocationId());
        CampaignStatus status = campaignStatusRepository.findByStatusId(campaignForm.getCampaignStatusId());
        Domain domain = domainRepository.findByDomainId(campaignForm.getDomainId());
        SocialMediaPlatform socialMediaPlatform = socialMediaPlatformRepository.findById(campaignForm.getPlatformId()).get();
        Campaign campaign = campaignForm.getCampaign(employee,location,status,domain,socialMediaPlatform);
        campaign.setSubmissions(campaignRepository.findByCampaignId(campaignForm.getCampaignId()).getSubmissions());
        return campaignRepository.save(campaign);
    }


    @DeleteMapping(value = "/campaigns/{campaign_id}", produces = "application/json")
    public void removeCampaign(@PathVariable Integer campaign_id){
        campaignRepository.deleteById(campaign_id);
    }

}
