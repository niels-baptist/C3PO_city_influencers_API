package com.example.bookinfoservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="submission", schema = "nocaps")
@JsonIgnoreProperties(value = {"campaign","hibernateLazyInitializer"}, allowSetters = true)
public class Submission {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "\"submission_id\"")
    private int submissionId;


    @Column(name = "\"url\"")
    private String url;
    @Column(name = "\"description\"")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="status_id", nullable=true)
    private SubmissionStatus submissionStatus;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="\"campaign_id\"", nullable=true)
    private Campaign campaign;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="\"influencer_id\"", nullable=true)
    private Influencer influencer;

    public Submission() {
    }

    public Submission(String url, String description, SubmissionStatus submissionStatus, Campaign campaign, Influencer influencer) {
        this.url = url;
        this.description = description;
        this.submissionStatus = submissionStatus;
        this.campaign = campaign;
        this.influencer = influencer;
    }

    public int getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(int submissionId) {
        this.submissionId = submissionId;
    }

    public SubmissionStatus getSubmissionStatus() {
        return submissionStatus;
    }

    public void setSubmissionStatus(SubmissionStatus submissionStatus) {
        this.submissionStatus = submissionStatus;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public Influencer getInfluencer() {
        return influencer;
    }

    public void setInfluencer(Influencer influencer) {
        this.influencer = influencer;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Submission(int submissionId, String url, String description, SubmissionStatus submissionStatus) {
        this.submissionId = submissionId;
        this.url = url;
        this.description = description;
        this.submissionStatus = submissionStatus;
    }

    public Submission(int submissionId, String url, String description, SubmissionStatus submissionStatus, Campaign campaign, Influencer influencer) {
        this.submissionId = submissionId;
        this.url = url;
        this.description = description;
        this.submissionStatus = submissionStatus;
        this.campaign = campaign;
        this.influencer = influencer;
    }
}
