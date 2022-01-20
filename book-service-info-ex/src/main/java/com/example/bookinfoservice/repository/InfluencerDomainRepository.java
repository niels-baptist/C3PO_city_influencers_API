package com.example.bookinfoservice.repository;

import com.example.bookinfoservice.model.InfluencerDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfluencerDomainRepository extends JpaRepository<InfluencerDomain, Integer> {
}