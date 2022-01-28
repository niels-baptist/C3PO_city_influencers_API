package com.example.bookinfoservice.repository;

import com.example.bookinfoservice.model.Influencer;
import com.example.bookinfoservice.model.SocialMediaAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SocialMediaAccountRepository extends JpaRepository<SocialMediaAccount, Integer> {
    @Query(value="select a from SocialMediaAccount a where a.platform.social_media_platformId=?1")
    List<SocialMediaAccount> findAllByPlatformPlatformId(int platform_id);
    List<SocialMediaAccount> findAllByInfluencerId(int influencer_id);
}