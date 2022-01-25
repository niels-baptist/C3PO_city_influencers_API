package com.example.bookinfoservice.repository;

import com.example.bookinfoservice.model.Employee;
import com.example.bookinfoservice.model.Influencer;
import com.example.bookinfoservice.model.SocialMediaAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfluencerRepository extends JpaRepository<Influencer, Integer> {
    Influencer findByInfluencerId(int influencer_id);
    List<Influencer> findAll();
    @Query(value="select i from Influencer i where i.user.userName=?1")
    List<Influencer> findAllByuserUserName(String user_email);

}
