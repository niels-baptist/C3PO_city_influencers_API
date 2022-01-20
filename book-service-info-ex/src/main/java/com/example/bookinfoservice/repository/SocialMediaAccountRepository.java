package com.example.bookinfoservice.repository;

import com.example.bookinfoservice.model.SocialMediaAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialMediaAccountRepository extends JpaRepository<SocialMediaAccount, Integer> {
}