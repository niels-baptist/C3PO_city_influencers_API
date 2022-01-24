package com.example.bookinfoservice.repository;

import com.example.bookinfoservice.model.Campaign;
import com.example.bookinfoservice.model.Domain;
import com.example.bookinfoservice.model.Influencer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Integer> {
    Campaign findByCampaignId(int campaignId);
    List<Campaign> findAllByDomainsContaining(Domain domain);
}