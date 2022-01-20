package com.example.bookinfoservice.model;

import javax.persistence.*;

@Entity
@Table(name="campaign_status", schema = "nocaps")
public class CampaignStatus {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "\"status_id\"")
    private int campaignId;
    @Column(name = "\"name\"")
    private String name;

    public CampaignStatus() {
    }

    public CampaignStatus(int campaignId, String name) {
        this.campaignId = campaignId;
        this.name = name;
    }

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
