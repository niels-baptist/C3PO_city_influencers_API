package com.example.bookinfoservice.model;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="campaign", schema = "public")
@JsonIgnoreProperties(value = {"socialMediaAccounts","hibernateLazyInitializer"}, allowSetters = true)
public class Campaign {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "\"campaign_id\"")
    private int campaignId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="\"employee_id\"", nullable=true)
    private Employee employee;


    @Column(name = "\"name\"")
    private String name;
    @Column(name = "\"description\"")
    private String description;
    @Column(name = "\"foto_url\"")
    private String fotoUrl;
    @Column(name = "\"start_date\"")
    private Date startDate;
    @Column(name = "\"end_date\"")
    private Date endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="\"location_id\"", nullable=true)
    private Location location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="\"status_id\"", nullable=true)
    private CampaignStatus campaignStatus;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "campaign")
    private List<Submission> submissions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="\"domain_id\"")
    private Domain domain;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="\"social_media_platform_id\"")
    private SocialMediaPlatform socialMediaPlatform;




    public Campaign() {
    }

    public Campaign(Employee employee, String name, String description, String fotoUrl, Date startDate, Date endDate, Location location, CampaignStatus campaignStatus, Domain domain, SocialMediaPlatform socialMediaPlatform) {
        this.employee = employee;
        this.name = name;
        this.description = description;
        this.fotoUrl = fotoUrl;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.campaignStatus = campaignStatus;
        this.domain = domain;
        this.socialMediaPlatform = socialMediaPlatform;
    }

    public Campaign(int campaignId, Employee employee, String name, String description, String fotoUrl, Date startDate, Date endDate, Location location, CampaignStatus campaignStatus, List<Submission> submissions, Domain domain, SocialMediaPlatform platform) {
        this.campaignId = campaignId;
        this.employee = employee;
        this.name = name;
        this.description = description;
        this.fotoUrl = fotoUrl;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.campaignStatus = campaignStatus;
        this.submissions = submissions;
        this.domain = domain;
        this.socialMediaPlatform = platform;
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

    public List<Submission> getSubmissions() {
        return submissions;
    }

    public void setSubmissions(List<Submission> submissions) {
        this.submissions = submissions;
    }

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    public SocialMediaPlatform getSocialMediaPlatform() {
        return socialMediaPlatform;
    }

    public void setSocialMediaPlatform(SocialMediaPlatform platform) {
        this.socialMediaPlatform = platform;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


}
