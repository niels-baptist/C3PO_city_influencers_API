package com.example.bookinfoservice.model;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class InfluencerDomain implements Serializable {

    @Column(name = "\"domain_id\"")
    private int domainId;
    @Column(name = "\"influencer_id\"")
    private int influencerId;

    public InfluencerDomain(int domainId, int influencerId) {
        this.domainId = domainId;
        this.influencerId = influencerId;
    }

    public InfluencerDomain() {
    }

    public int getDomainId() {
        return domainId;
    }

    public void setDomainId(int domainId) {
        this.domainId = domainId;
    }

    public int getInfluencerId() {
        return influencerId;
    }

    public void setInfluencerId(int influencerId) {
        this.influencerId = influencerId;
    }
}
