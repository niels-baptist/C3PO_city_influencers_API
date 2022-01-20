package com.example.bookinfoservice.repository;

import com.example.bookinfoservice.model.CampaignPlatform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignPlatformRepository extends JpaRepository<CampaignPlatform, Integer> {
}