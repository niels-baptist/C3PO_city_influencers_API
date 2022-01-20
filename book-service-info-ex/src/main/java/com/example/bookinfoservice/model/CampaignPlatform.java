package com.example.bookinfoservice.model;

import javax.persistence.*;

@Entity
@Table(name="campaign_platform", schema = "nocaps")
public class CampaignPlatform {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "\"campaign_id\"")
    private int campaignId;
    @Column(name = "\"social_media_platform_id\"")
    private int socialMediaPlatformId;

    public CampaignPlatform() {
    }

    public CampaignPlatform(int campaignId, int socialMediaPlatformId) {
        this.campaignId = campaignId;
        this.socialMediaPlatformId = socialMediaPlatformId;
    }

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    public int getSocialMediaPlatformId() {
        return socialMediaPlatformId;
    }

    public void setSocialMediaPlatformId(int socialMediaPlatformId) {
        this.socialMediaPlatformId = socialMediaPlatformId;
    }
}