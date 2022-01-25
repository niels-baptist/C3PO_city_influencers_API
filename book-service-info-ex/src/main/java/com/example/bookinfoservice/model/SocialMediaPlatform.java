package com.example.bookinfoservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="social_media_platform", schema = "nocaps")
@JsonIgnoreProperties(value = {"accounts","campaigns","hibernateLazyInitializer"}, allowSetters = true)
public class SocialMediaPlatform {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "\"social_media_platform_id\"")
    private int socialMediaPlatformId;
    @Column(name = "\"name\"")
    private String name;
    @Column(name = "\"url\"")
    private String url;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "platform")
    private List<SocialMediaAccount> accounts;

    @ManyToMany(mappedBy = "platforms")
    Set<Campaign> campaigns;

    public SocialMediaPlatform(int social_media_platformId, String name, String url) {
        this.socialMediaPlatformId = social_media_platformId;
        this.name = name;
        this.url = url;
    }

    public SocialMediaPlatform() {
    }

    public int getSocialMediaPlatformId() {
        return socialMediaPlatformId;
    }

    public void setSocialMediaPlatformId(int social_media_platformId) {
        this.socialMediaPlatformId = social_media_platformId;
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
