package com.example.bookinfoservice.model;

import javax.persistence.*;

@Entity
@Table(name="social_media_platform", schema = "nocaps")
public class SocialMediaPlatform {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "\"social_media_platform_id\"")
    private int social_media_platformId;
    @Column(name = "\"name\"")
    private String name;
    @Column(name = "\"url\"")
    private String url;

    public SocialMediaPlatform(int social_media_platformId, String name, String url) {
        this.social_media_platformId = social_media_platformId;
        this.name = name;
        this.url = url;
    }

    public SocialMediaPlatform() {
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