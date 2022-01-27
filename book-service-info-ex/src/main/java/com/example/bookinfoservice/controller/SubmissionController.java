package com.example.bookinfoservice.controller;

import com.example.bookinfoservice.model.Campaign;
import com.example.bookinfoservice.model.Influencer;
import com.example.bookinfoservice.model.Submission;
import com.example.bookinfoservice.model.SubmissionStatus;
import com.example.bookinfoservice.repository.CampaignRepository;
import com.example.bookinfoservice.repository.InfluencerRepository;
import com.example.bookinfoservice.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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




    // CRUD submissions
    @GetMapping("/submissions")public List<Submission> getSubmissions(){return submissionRepository.findAll();}

    @PostMapping("/submissions")
    public Submission addSubmission(@RequestBody Submission submission){
        return submissionRepository.save(new Submission(submission.getUrl(), submission.getDescription(), submission.getSubmissionStatus(), submission.getCampaign(), submission.getInfluencer()));
    }

    @PutMapping("/submissions")
    public Submission updateSubmission(@RequestBody Submission submission){
        return submissionRepository.save(submission);
    }
    @DeleteMapping("/submissions/{submission_id}")
    public void deleteSubmission(@PathVariable int submission_id){
        submissionRepository.deleteById(submission_id);
    }
}
