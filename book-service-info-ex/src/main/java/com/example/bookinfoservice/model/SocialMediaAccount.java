package com.example.bookinfoservice.model;

import javax.persistence.*;

@Entity
@Table(name="social_media_account", schema = "nocaps")
public class SocialMediaAccount {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "\"social_media_account_id\"")
    private int social_media_accountId;
    @Column(name = "\"influencer_id\"")
    private int influencerId;
    @Column(name = "\"social_media_platform_id\"")
    private int social_media_platformId;
    @Column(name = "\"name\"")
    private String name;
    @Column(name = "\"url\"")
    private String url;

    public SocialMediaAccount() {
    }

    public SocialMediaAccount(int social_media_accountId, int influencerId, int social_media_platformId, String name, String url) {
        this.social_media_accountId = social_media_accountId;
        this.influencerId = influencerId;
        this.social_media_platformId = social_media_platformId;
        this.name = name;
        this.url = url;
    }

    public int getSocial_media_accountId() {
        return social_media_accountId;
    }

    public void setSocial_media_accountId(int social_media_accountId) {
        this.social_media_accountId = social_media_accountId;
    }

    public int getInfluencerId() {
        return influencerId;
    }

    public void setInfluencerId(int influencerId) {
        this.influencerId = influencerId;
    }

    public int getSocial_media_platformId() {
        return social_media_platformId;
    }

    public void setSocial_media_platformId(int social_media_platformId) {
        this.social_media_platformId = social_media_platformId;
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
}
