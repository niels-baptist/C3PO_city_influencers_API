package com.example.bookinfoservice.controller;

import com.example.bookinfoservice.model.Campaign;
import com.example.bookinfoservice.model.Submission;
import com.example.bookinfoservice.repository.CampaignRepository;
import com.example.bookinfoservice.repository.InfluencerRepository;
import com.example.bookinfoservice.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
public class SubmissionController  {
    @Autowired
    SubmissionRepository submissionRepository;
    @Autowired
    CampaignRepository campaignRepository;

    @GetMapping("/submissions/influencer/{influencer_id}")
    public List<Campaign> getRecomendedCampaignsByInfluencerId(@PathVariable Integer influencer_id){
        List<Submission> submissions = submissionRepository.findAllByInfluencerInfluencerIdAndSubmissionStatus_StatusId(influencer_id,1);
        List<Campaign> campaignes = submissions.stream().map(s ->campaignRepository.findByCampaignId(s.getCampaign().getCampaignId())).collect(Collectors.toList());
        return campaignes;
    }
}
