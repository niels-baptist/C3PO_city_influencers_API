package com.example.bookinfoservice.model;
import javax.persistence.*;
import java.util.Date;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name="user", schema = "nocaps")
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
    @Column(name = "\"birth_date\"")
    private Date birthdate;



    public User(){}

    public User(int userId, Location location, String email, String password, String firstname, String lastname, Date birthdate) {
        this.userId = userId;
        this.location = location;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Location getLocationId() {
        return location;
    }

    public void setLocationId(Location locationId) {
        this.location = locationId;
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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
}
