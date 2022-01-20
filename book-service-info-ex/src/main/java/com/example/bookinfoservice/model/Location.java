package com.example.bookinfoservice.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name="location", schema = "nocaps")
@JsonIgnoreProperties(value = {"users","hibernateLazyInitializer"}, allowSetters = true)
public class Location {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "\"location_id\"")
    private int locationId;
    @Column(name = "\"name\"")
    private String name;
    @Column(name = "\"postal_code\"")
    private String postalCode;

    @OneToMany(mappedBy = "location",
            orphanRemoval = true,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<User> users;

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
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
