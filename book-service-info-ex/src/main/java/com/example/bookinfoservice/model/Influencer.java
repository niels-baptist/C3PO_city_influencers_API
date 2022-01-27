package com.example.bookinfoservice.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="influencer", schema = "nocaps")
public class Influencer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "\"influencer_id\"")
    private int influencerId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=true)
    private User user;
    @Column(name = "\"gender\"")
    private String gender;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "influencer")
    private List<Submission> submissions;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "influencer")
    private List<SocialMediaAccount> accounts;

    @ManyToMany
    @JoinTable(
            name = "influencer_domain",
            joinColumns = @JoinColumn(name = "influencer_id"),
            inverseJoinColumns = @JoinColumn(name = "domain_id"))
    Set<Domain> domains;

    public Influencer(int influencerId, User user,Set<Domain> domains, String gender) {
        this.influencerId = influencerId;
        this.user = user;
        this.domains = domains;
        this.gender = gender;
    }

    public Influencer(User user, String gender) {
        this.user = user;
        this.gender = gender;
    }

    public Influencer() {
    }

    public int getinfluencerId() {
        return influencerId;
    }

    public void setinfluencerId(int influencer_id) {
        this.influencerId = influencer_id;
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
}
