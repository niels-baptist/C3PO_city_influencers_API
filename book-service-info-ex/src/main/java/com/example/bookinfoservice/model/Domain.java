package com.example.bookinfoservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="domain", schema = "nocaps")
@JsonIgnoreProperties(value = {"influencers","campaigns","hibernateLazyInitializer"}, allowSetters = true)
public class Domain {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "\"domain_id\"")
    private int domainId;
    @Column(name = "\"name\"")
    private String name;
    @Column(name = "\"description\"")
    private String description;

    @ManyToMany(mappedBy = "domains")
    Set<Influencer> influencers;
    @ManyToMany(mappedBy = "domains")
    Set<Campaign> campaigns;

    public Domain() {
    }

    public Domain(int domanId, String name, String description) {
        this.domainId = domanId;
        this.name = name;
        this.description = description;
    }

    // constructor used to create new Domain
    public Domain(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public int getDomainId() {
        return domainId;
    }

    public void setDomainId(int domanId) {
        this.domainId = domanId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Influencer> getInfluencers() {
        return influencers;
    }

    public void setInfluencers(Set<Influencer> influencers) {
        this.influencers = influencers;
    }

    public Set<Campaign> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(Set<Campaign> campaigns) {
        this.campaigns = campaigns;
    }
}
