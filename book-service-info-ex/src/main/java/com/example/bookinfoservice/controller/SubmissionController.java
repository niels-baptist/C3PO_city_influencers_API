package com.example.bookinfoservice.controller;

import com.example.bookinfoservice.model.Campaign;
import com.example.bookinfoservice.model.Influencer;
import com.example.bookinfoservice.model.Submission;
import com.example.bookinfoservice.model.SubmissionStatus;
import com.example.bookinfoservice.repository.CampaignRepository;
import com.example.bookinfoservice.repository.InfluencerRepository;
import com.example.bookinfoservice.repository.SubmissionRepository;
import com.example.bookinfoservice.repository.SubmissionStatusRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;



@CrossOrigin
@RestController
public class SubmissionController  {
    @Autowired
    SubmissionRepository submissionRepository;
    @Autowired
    SubmissionStatusRepository submissionStatusRepository;
    @Autowired
    CampaignRepository campaignRepository;
    @Autowired
    InfluencerRepository influencerRepository;




    // CRUD submissions
    @GetMapping("/submissions")public List<Submission> getSubmissions(){return submissionRepository.findAll();}

    @PostMapping("/submissions")
    public Submission addSubmission(@RequestBody Submission submission){
        return submissionRepository.save(new Submission(submission.getUrl(), submission.getDescription(), submission.getSubmissionStatus(), submission.getCampaign(),submission.getInfluencer()));
    }

    @PostMapping("/submissions/{campaign_id}")
    public Submission addSubmissionToCampaign(@RequestBody Submission submission, @PathVariable int campaign_id){
        submission.setCampaign(campaignRepository.findByCampaignId(campaign_id));
        return submissionRepository.save(new Submission(submission.getUrl(), submission.getDescription(), submission.getSubmissionStatus(), submission.getCampaign(),submission.getInfluencer()));
    }

    @PutMapping("/submissions")
    public Submission updateSubmission(@RequestBody Submission submission){
        return submissionRepository.save(submission);
    }
    @DeleteMapping("/submissions/{submission_id}")
    public void deleteSubmission(@PathVariable int submission_id){
        submissionRepository.deleteById(submission_id);
    }

    // complexer get mappings
    @GetMapping("/submissions/influencer/{influencer_id}")public List<Submission> getSubmissionsByInfluencer(@PathVariable int influencer_id){
        return submissionRepository.findAllByInfluencerInfluencerId(influencer_id);
    }

    @GetMapping("/submissions/{influencer_id}/{campaign_id}")public Submission getSubmissionsByInfluencerIdAndCampaignId(@PathVariable Map<String, String> json){
        // used to join a campaign and create a submission
        int influencer_id = parseInt(json.get("influencer_id"));
        int campaign_id = parseInt(json.get("campaign_id"));
        Submission submission = submissionRepository.findByInfIdAndCampId(influencer_id,campaign_id);
        if (submission == null){
            Campaign campaign = campaignRepository.findByCampaignId(campaign_id);
            Influencer influencer = influencerRepository.findByInfluencerId(influencer_id);
            if (campaign.getCampaignStatus().getStatusId() != 2){throw new ResponseStatusException(HttpStatus.FORBIDDEN,"The campaign was not open nor had the user a submission to the campaign.");}
            submission = submissionRepository.save(new Submission("", "", submissionStatusRepository.findByStatusId(1),campaign ,influencer));
        }
        return submission;
    }

    @PostMapping("/submissions/{influencer_id}/{campaign_id}")public Submission createSubmissionsByInfluencerIdAndCampaignId(@PathVariable Map<String, String> json){
        // used to join a campaign and create a submission
        int influencer_id = parseInt(json.get("influencer_id"));
        int campaign_id = parseInt(json.get("campaign_id"));
        Submission submission = submissionRepository.findByInfIdAndCampId(influencer_id,campaign_id);
        if (submission == null){
            Campaign campaign = campaignRepository.findByCampaignId(campaign_id);
            Influencer influencer = influencerRepository.findByInfluencerId(influencer_id);
            if (campaign.getCampaignStatus().getStatusId() != 2){throw new ResponseStatusException(HttpStatus.FORBIDDEN,"The campaign was not open nor had the user a submission to the campaign.");}
            submission = submissionRepository.save(new Submission("", "", submissionStatusRepository.findByStatusId(1),campaign ,influencer));
        }
        return submission;
    }
}
