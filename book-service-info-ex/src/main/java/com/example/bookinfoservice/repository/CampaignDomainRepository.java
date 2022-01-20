package com.example.bookinfoservice.repository;

import com.example.bookinfoservice.model.CampaignDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignDomainRepository extends JpaRepository<CampaignDomain, Integer> {
}