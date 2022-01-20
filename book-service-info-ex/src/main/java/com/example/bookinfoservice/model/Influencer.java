package com.example.bookinfoservice.model;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;


@Entity
@Table(name="influencer", schema = "nocaps")
public class Influencer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "\"influencer_id\"")
    private int influencerId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=true)
    private User user;
    @Column(name = "\"gender\"")
    private String gender;

    public Influencer(int influencerId, User user, String gender) {
        this.influencerId = influencerId;
        this.user = user;
        this.gender = gender;
    }

    public Influencer() {
    }

    public int getinfluencerId() {
        return influencerId;
    }

    public void setinfluencerId(int influencer_id) {
        this.influencerId = influencer_id;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
