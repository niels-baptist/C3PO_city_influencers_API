package com.example.bookinfoservice.model;

import javax.persistence.*;

@Entity
@Table(name="campaign", schema = "nocaps")
public class Campaign {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "\"campaign_id\"")
    private int campaignId;
    @Column(name = "\"employee_id\"")
    private int employeeId;
    @Column(name = "\"location_id\"")
    private int locationId;
    @Column(name = "\"status_id\"")
    private int statusId;
    @Column(name = "\"name\"")
    private String name;
    @Column(name = "\"description\"")
    private String description;
    @Column(name = "\"foto_url\"")
    private String fotoUrl;

    public Campaign() {
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

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
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

    public Campaign(int campaignId, int employeeId, int locationId, int statusId, String name, String description, String fotoUrl) {
        this.campaignId = campaignId;
        this.employeeId = employeeId;
        this.locationId = locationId;
        this.statusId = statusId;
        this.name = name;
        this.description = description;
        this.fotoUrl = fotoUrl;
    }
}
