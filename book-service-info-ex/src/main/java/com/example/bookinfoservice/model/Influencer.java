package com.example.bookinfoservice.model;
import javax.persistence.*;


@Entity
@Table(name="influencer", schema = "nocaps")
public class Influencer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "\"influencer_id\"")
    private int influencerId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userId", nullable=true)
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

    public User getUserId() {
        return user;
    }

    public void setUserId(User user) {
        this.user = user;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
