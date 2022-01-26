package com.example.bookinfoservice.repository;

import com.example.bookinfoservice.model.Campaign;
import com.example.bookinfoservice.model.Domain;
import com.example.bookinfoservice.model.Influencer;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Integer> {
    Campaign findByCampaignId(int campaignId);
    List<Campaign> findAllByDomainsContaining(Domain domain);
    // native sql query works better in this case.
    @Query(value = "SELECT * FROM nocaps.campaign c INNER JOIN nocaps.submission s on s.campaign_id = c.campaign_id WHERE s.status_id = :statusId AND s.influencer_id = :influencer_id AND c.status_id = :campaignStatus",nativeQuery = true)
    List<Campaign> findAllByStatusIdAndInfluencerId(@Param("statusId") int status_id, @Param("influencer_id") int influencer_id,
                                                    @Param("campaignStatus") int campaign_status_id);
}