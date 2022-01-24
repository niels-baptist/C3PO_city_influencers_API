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
public class CampaignController {
    @Autowired
    InfluencerRepository influencerRepository;
    @Autowired
    CampaignRepository campaignRepository;
    // Get all campaigns on submissions with specified influencerId
    @Autowired
    SubmissionRepository submissionRepository;
    @GetMapping("/campaigns/recomended/{influecner_id}")
    public List<Campaign> getRecomendedCampaignsByInfluencerId(@PathVariable Integer influencer_id){
        List<Submission> submissions = submissionRepository.findAllByInfluencerInfluencerIdAndSubmissionStatus_StatusId(influencer_id,1);
        List<Campaign>campaignes = submissions.stream().map(s ->campaignRepository.findByCampaignId(s.getCampaign().getCampaignId())).collect(Collectors.toList());
        return campaignes;
    }
    @GetMapping("/campaigns/domainFilter/{influencer_id}")
    public List<Campaign> getOpenCampaignsByDomains(@PathVariable Integer influencer_id){
        Set<Domain> domains = influencerRepository.findByInfluencerId(influencer_id).getDomains();
        List<Campaign> campaigns = domains.stream().map(d -> campaignRepository.findAllByDomainsContaining(d)).flatMap(List::stream).collect(Collectors.toList());
        return campaigns;
    }

}
