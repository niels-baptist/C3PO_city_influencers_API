package com.example.bookinfoservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="influencer", schema = "nocaps")
@JsonIgnoreProperties(value = {"submissions","hibernateLazyInitializer"}, allowSetters = true)
public class Influencer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "\"influencer_id\"")
    private int influencerId;
    @Column(name="\"picture_url\"")
    private String pictureUrl;
    @Column(name = "\"gender\"")
    private String gender;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=true)
    private User user;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "influencer")
    private List<Submission> submissions;


    @ManyToMany
    @JoinTable(
            name = "influencer_domain",
            joinColumns = @JoinColumn(name = "influencer_id"),
            inverseJoinColumns = @JoinColumn(name = "domain_id"))
    Set<Domain> domains;

    public Influencer(int influencerId, String pictureUrl, String gender, User user, List<Submission> submissions, Set<Domain> domains) {
        this.influencerId = influencerId;
        this.pictureUrl = pictureUrl;
        this.gender = gender;
        this.user = user;
        this.submissions = submissions;
        this.domains = domains;
    }

    public Influencer(User user, String gender) {
        this.user = user;
        this.gender = gender;
    }

    public Influencer(String pictureUrl, String gender, User user, Set<Domain> domains) {
        this.pictureUrl = pictureUrl;
        this.gender = gender;
        this.user = user;
        this.domains = domains;
    }

    public Influencer() {
    }



    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Set<Domain> getDomains() {
        return domains;
    }

    public void setDomains(Set<Domain> influencerDomains) {
        this.domains = influencerDomains;
    }

    public int getInfluencerId() {
        return influencerId;
    }

    public void setInfluencerId(int influencerId) {
        this.influencerId = influencerId;
    }

    public List<Submission> getSubmissions() {
        return submissions;
    }

    public void setSubmissions(List<Submission> submissions) {
        this.submissions = submissions;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
