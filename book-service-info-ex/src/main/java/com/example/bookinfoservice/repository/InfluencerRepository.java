package com.example.bookinfoservice.repository;

import com.example.bookinfoservice.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfluencerRepository extends JpaRepository<Influencer, Integer> {
    Influencer findByInfluencerId(int influencer_id);
    List<Influencer> findAllBy();
    @Query(value="select i from Influencer i where i.user.userName=?1",nativeQuery = false)
    List<Influencer> findAllByuserUserName(String user_email);

    // use of a native sql query, this is due to the necesatie of the join of the 2 tables. Else there would have to be 2 querys.
    @Query(value = "SELECT * FROM public.influencer i INNER JOIN public.social_media_account s ON i.influencer_id = s.influencer_id WHERE s.social_media_platform_id = ?1",nativeQuery = true)
    List<Influencer> findAllByPlatformId(int platformId);
    List<Influencer> findAllByDomainsContaining(Domain domain);

    @Query(value = "SELECT * FROM public.influencer i INNER JOIN public.submission s ON i.influencer_id = s.influencer_id WHERE s.campaign_id = ?1",nativeQuery = true)
    List<Influencer> findAllByCampaign(int campaign_id);

}
