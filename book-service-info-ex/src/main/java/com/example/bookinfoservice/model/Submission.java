package com.example.bookinfoservice.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="submission", schema = "nocaps")
public class Submission {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "\"submission_id\"")
    private int submissionId;
    @Column(name = "\"influencer_id\"")
    private int influencerId;
    @Column(name = "\"campaign_id\"")
    private int campaignId;
    @Column(name = "\"status_id\"")
    private int statusId;
    @Column(name = "\"url\"")
    private String url;
    @Column(name = "\"description\"")
    private String description;

    public Submission() {
    }

    public int getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(int submissionId) {
        this.submissionId = submissionId;
    }

    public int getInfluencerId() {
        return influencerId;
    }

    public void setInfluencerId(int influencerId) {
        this.influencerId = influencerId;
    }

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
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

    public Submission(int submissionId, int influencerId, int campaignId, int statusId, String url, String description) {
        this.submissionId = submissionId;
        this.influencerId = influencerId;
        this.campaignId = campaignId;
        this.statusId = statusId;
        this.url = url;
        this.description = description;
    }
}
