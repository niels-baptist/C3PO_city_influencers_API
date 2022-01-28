package com.example.bookinfoservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="social_media_account", schema = "nocaps")
@JsonIgnoreProperties(value = {"influencer","hibernateLazyInitializer"}, allowSetters = true)
public class SocialMediaAccount {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "\"social_media_account_id\"")
    private int socialMediaAccountId;
    @Column(name = "\"influencer_id\"")
    private int influencerId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="platform_id", nullable=true)
    private SocialMediaPlatform platform;
    @Column(name = "\"name\"")
    private String name;
    @Column(name = "\"url\"")
    private String url;

    public SocialMediaAccount() {
    }

    public SocialMediaAccount(int socialMediaAccountId, int influencer_id, SocialMediaPlatform platform, String name, String url) {
        this.socialMediaAccountId = socialMediaAccountId;
        this.influencerId = influencer_id;
        this.platform = platform;
        this.name = name;
        this.url = url;
    }

    public SocialMediaAccount(int influencer_id, SocialMediaPlatform platform, String name, String url) {
        this.influencerId = influencer_id;
        this.platform = platform;
        this.name = name;
        this.url = url;
    }

    public int getSocialMediaAccountId() {
        return socialMediaAccountId;
    }

    public void setSocialMediaAccountId(int social_media_accountId) {
        this.socialMediaAccountId = social_media_accountId;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getInfluencerId() {
        return influencerId;
    }

    public void setInfluencerId(int influencer_id) {
        this.influencerId = influencer_id;
    }

    public SocialMediaPlatform getPlatform() {
        return platform;
    }

    public void setPlatform(SocialMediaPlatform platform) {
        this.platform = platform;
    }


}
