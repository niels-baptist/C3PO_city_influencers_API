package com.example.bookinfoservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="campaign_status", schema = "public")
@JsonIgnoreProperties(value = {"campaigns","hibernateLazyInitializer"}, allowSetters = true)
public class CampaignStatus {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "\"status_id\"")
    private int statusId;
    @Column(name = "\"name\"")
    private String name;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "campaignStatus")
    private List<Campaign> campaigns;

    public CampaignStatus() {
    }

    public CampaignStatus(int campaignId, String name) {
        this.statusId = campaignId;
        this.name = name;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int campaignId) {
        this.statusId = campaignId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
