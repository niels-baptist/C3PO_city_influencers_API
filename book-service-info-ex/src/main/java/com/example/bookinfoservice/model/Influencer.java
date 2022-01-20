package com.example.bookinfoservice.model;
import javax.persistence.*;

@Entity
@Table(name="influencer", schema = "nocaps")
public class Influencer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "\"influencer_id\"")
    private int influencerId;
    @Column(name = "\"user_id\"")
    private int userId;
    @Column(name = "\"gender\"")
    private String gender;

    public Influencer(int influencerId, int user_id, String gender) {
        this.influencerId = influencerId;
        this.userId = user_id;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int user_id) {
        this.userId = user_id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
