package com.example.bookinfoservice.model;
import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name="location", schema = "nocaps")
public class Location {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "\"location_id\"")
    private int locationId;
    @Column(name = "\"name\"")
    private String name;
    @Column(name = "\"postal_code\"")
    private String postalCode;

    @OneToMany(cascade = ALL,mappedBy = "location")
    private List<User> Users;

    public Location(int locationId, String name, String postalCode) {
        this.locationId = locationId;
        this.name = name;
        this.postalCode = postalCode;
    }

    public Location() {
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return Users;
    }

    public void setUsers(List<User> users) {
        Users = users;
    }
}
