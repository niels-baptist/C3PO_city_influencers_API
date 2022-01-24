package com.example.bookinfoservice.model;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="campaign", schema = "nocaps")
@JsonIgnoreProperties(value = {"employee","socialMediaAccounts","hibernateLazyInitializer"}, allowSetters = true)
public class Campaign {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "\"campaign_id\"")
    private int campaignId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="\"employee_id\"", nullable=true)
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="\"location_id\"", nullable=true)
    private Location location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="\"status_id\"", nullable=true)
    private CampaignStatus campaignStatus;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "campaign")
    private List<Submission> submissions;

    @Column(name = "\"name\"")
    private String name;
    @Column(name = "\"description\"")
    private String description;
    @Column(name = "\"foto_url\"")
    private String fotoUrl;

    @ManyToMany
    @JoinTable(
            name = "campaign_domain",
            joinColumns = @JoinColumn(name = "campaign_id"),
            inverseJoinColumns = @JoinColumn(name = "domain_id"))
    Set<Domain> domains;

    @ManyToMany
    @JoinTable(
            name = "campaign_platform",
            joinColumns = @JoinColumn(name = "campaign_id"),
            inverseJoinColumns = @JoinColumn(name = "social_media_platform_id"))
    Set<SocialMediaPlatform> platforms;

    public Campaign() {
    }

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public CampaignStatus getCampaignStatus() {
        return campaignStatus;
    }

    public void setCampaignStatus(CampaignStatus campaignStatus) {
        this.campaignStatus = campaignStatus;
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

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public Set<Domain> getDomains() {
        return domains;
    }

    public void setDomains(Set<Domain> domains) {
        this.domains = domains;
    }

    public List<Submission> getSubmissions() {
        return submissions;
    }

    public void setSubmissions(List<Submission> submissions) {
        this.submissions = submissions;
    }

    public Campaign(int campaignId, Employee employee, Location location, CampaignStatus campaignStatus, List<Submission> submissions, String name, String description, String fotoUrl, Set<Domain> domains) {
        this.campaignId = campaignId;
        this.employee = employee;
        this.location = location;
        this.campaignStatus = campaignStatus;
        this.submissions = submissions;
        this.name = name;
        this.description = description;
        this.fotoUrl = fotoUrl;
        this.domains = domains;
    }
}
