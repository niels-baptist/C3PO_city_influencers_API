package com.example.bookinfoservice.repository;

import com.example.bookinfoservice.model.SocialMediaPlatform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialMediaPlatformRepository extends JpaRepository<SocialMediaPlatform, Integer> {
    SocialMediaPlatform findBySocial_media_platformId(int platformId);
}