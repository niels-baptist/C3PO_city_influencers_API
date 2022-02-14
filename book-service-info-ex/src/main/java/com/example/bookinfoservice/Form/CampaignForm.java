package com.example.bookinfoservice.Form;

import com.example.bookinfoservice.model.*;

import java.util.Date;
import java.util.Locale;

public class CampaignForm {
    private int campaignId;
    private int employeeId;
    private int domainId;
    private int platformId;
    private int campaignStatusId;
    private int locationId;
    private String fotoUrl;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;

    public CampaignForm(int campaignId, int employeeId, int domainId, int platformId, int campaignStatusId, String fotoUrl, String name, String description, Date startDate, Date endDate, int locationId) {
        this.campaignId = campaignId;
        this.employeeId = employeeId;
        this.domainId = domainId;
        this.platformId = platformId;
        this.campaignStatusId = campaignStatusId;
        this.fotoUrl = fotoUrl;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.locationId = locationId;
    }

    public Campaign createCampaign(Employee employee, Location location, CampaignStatus campaignStatus, Domain domain, SocialMediaPlatform platform){
        return new Campaign(employee, name, description, fotoUrl,startDate,endDate, location, campaignStatus, domain, platform);
    }

    public Campaign getCampaign(Employee employee, Location location, CampaignStatus campaignStatus, Domain domain, SocialMediaPlatform platform){
        Campaign campaign = new Campaign(campaignId,employee, name, description, fotoUrl,startDate,endDate, location, campaignStatus,null, domain, platform);
        campaign.setCampaignId(campaignId);
        return campaign;
    }

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getDomainId() {
        return domainId;
    }

    public void setDomainId(int domainId) {
        this.domainId = domainId;
    }

    public int getPlatformId() {
        return platformId;
    }

    public void setPlatformId(int platformId) {
        this.platformId = platformId;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
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

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getCampaignStatusId() {
        return campaignStatusId;
    }

    public void setCampaignStatusId(int campaignStatusId) {
        this.campaignStatusId = campaignStatusId;
    }
}
