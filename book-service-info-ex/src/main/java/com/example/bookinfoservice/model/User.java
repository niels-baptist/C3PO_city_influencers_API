package com.example.bookinfoservice.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name="user", schema = "nocaps")
@JsonIgnoreProperties(value = {"influencer","employee","hibernateLazyInitializer"}, allowSetters = true)
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "\"user_id\"")
    private int userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="location_id", nullable=true)
    private Location location;
    @Column(name = "\"email\"")
    private String email;
    @Column(name = "\"password\"")
    private String password;
    @Column(name = "\"first_name\"")
    private String firstname;
    @Column(name = "\"last_name\"")
    private String lastname;
    @Column(name = "\"user_name\"")
    private String userName;
    @Column(name = "\"birth_date\"")
    private Date birthdate;

    @OneToOne(cascade=ALL,mappedBy = "user")
    private Influencer influencer;
    @OneToOne(cascade=ALL,mappedBy = "user")
    private Employee employee;


    public User(){}

    public User(int userId, Location location, String email, String password, String firstname, String lastname, String userName, Date birthdate, Influencer influencer, Employee employee) {
        this.userId = userId;
        this.location = location;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.userName = userName;
        this.birthdate = birthdate;
        this.influencer = influencer;
        this.employee = employee;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Influencer getInfluencer() {
        return influencer;
    }

    public void setInfluencer(Influencer influencer) {
        this.influencer = influencer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
