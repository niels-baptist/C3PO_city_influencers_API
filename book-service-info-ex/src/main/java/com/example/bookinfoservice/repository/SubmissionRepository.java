package com.example.bookinfoservice.repository;

import com.example.bookinfoservice.model.Influencer;
import com.example.bookinfoservice.model.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Integer> {
    @Query(value = "SELECT * FROM public.submission s INNER JOIN public.campaign c ON c.campaign_id = s.campaign_id WHERE s.influencer_id = :influencer_id AND s.campaign_id= :campaign_id",nativeQuery = true)
    Submission findByInfIdAndCampId(@Param("influencer_id") int influencer_id,@Param("campaign_id") int campaign_id);
    List<Submission> findAllByInfluencerInfluencerId(int influencer_id);

    Submission findBySubmissionId(int id);
}