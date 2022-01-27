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
public class CampaignController  {

    // campaign statusId: 1: saved , 2: open, 3: in afwachting van goedkeuring, 4: afgerond

    @Autowired
    InfluencerRepository influencerRepository;
    @Autowired
    CampaignRepository campaignRepository;
    // Get all campaigns on submissions with specified influencerId
    @Autowired
    SubmissionRepository submissionRepository;

    @GetMapping(value = "/campaigns", produces = "application/json")
    public List<Campaign> getCampaigns(){
        return campaignRepository.findAll();
    }

    @GetMapping(value = "/campaigns/{campaign_id}", produces = "application/json")
    public Campaign getCampaignByCampaignId(@PathVariable Integer campaign_id){
        return campaignRepository.findByCampaignId(campaign_id);
    }

    @GetMapping("/campaigns/recomended/{influencer_id}")
    public List<Campaign> getRecomendedCampaignsByInfluencerId(@PathVariable Integer influencer_id){
        return campaignRepository.findAllByStatusIdAndInfluencerId(1,influencer_id,2);
    }

    @GetMapping("/campaigns/openCampaigns/{influencer_id}")
    public List<Campaign> getOpenCampaignsByDomains(@PathVariable Integer influencer_id){
        // This call to the data base works better with lambda functions due to the amount of association tables that would be joined in native sql
        Set<Domain> domains = influencerRepository.findByInfluencerId(influencer_id).getDomains();
        List<Campaign> campaigns = domains.stream().map(d -> campaignRepository.findAllByDomainsContaining(d)).flatMap(List::stream).collect(Collectors.toList());
        return campaigns;
    }

    @PostMapping("/campaigns")
    public Campaign addCampaign(@RequestBody Campaign campaign){
        return campaignRepository.save(new Campaign(campaign.getEmployee(), campaign.getLocation(), campaign.getCampaignStatus(), campaign.getName(), campaign.getDescription(), campaign.getFotoUrl(), campaign.getDomains(), campaign.getPlatforms()));
    }

}
