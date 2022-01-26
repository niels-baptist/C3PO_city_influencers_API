package com.example.bookinfoservice.repository;

import com.example.bookinfoservice.model.CampaignStatus;
import com.example.bookinfoservice.model.Domain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainRepository extends JpaRepository<Domain, Integer>{
    Domain findByDomainId(int domain_id);
}
