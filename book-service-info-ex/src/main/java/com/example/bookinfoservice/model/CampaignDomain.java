package com.example.bookinfoservice.model;

import javax.persistence.*;

@Entity
@Table(name="campaign_domain", schema = "nocaps")
public class CampaignDomain {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "\"domain_id\"")
    private int domainId;
    @Column(name = "\"campaign_id\"")
    private int campaignId;

    public CampaignDomain() {
    }

    public CampaignDomain(int domainId, int campaignId) {
        this.domainId = domainId;
        this.campaignId = campaignId;
    }

    public int getDomainId() {
        return domainId;
    }

    public void setDomainId(int domainId) {
        this.domainId = domainId;
    }

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }
}
