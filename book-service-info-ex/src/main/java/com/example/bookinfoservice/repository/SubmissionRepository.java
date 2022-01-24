package com.example.bookinfoservice.repository;

import com.example.bookinfoservice.model.Influencer;
import com.example.bookinfoservice.model.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Integer> {
    List<Submission> findAllByInfluencerInfluencerId(int influecerId);
    List<Submission> findAllByInfluencerInfluencerIdAndSubmissionStatus_StatusId(int influecerId, int statusId);
}