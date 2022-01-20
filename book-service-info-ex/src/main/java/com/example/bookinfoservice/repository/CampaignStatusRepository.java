package com.example.bookinfoservice.repository;

import com.example.bookinfoservice.model.CampaignStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignStatusRepository extends JpaRepository<CampaignStatus, Integer> {
}