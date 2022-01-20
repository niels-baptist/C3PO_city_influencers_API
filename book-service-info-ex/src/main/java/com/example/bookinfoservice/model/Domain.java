package com.example.bookinfoservice.model;

import javax.persistence.*;

@Entity
@Table(name="domain", schema = "nocaps")
public class Domain {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "\"domain_id\"")
    private int domanId;
    @Column(name = "\"name\"")
    private String name;
    @Column(name = "\"description\"")
    private String description;

    public Domain() {
    }

    public Domain(int domanId, String name, String description) {
        this.domanId = domanId;
        this.name = name;
        this.description = description;
    }

    public int getDomanId() {
        return domanId;
    }

    public void setDomanId(int domanId) {
        this.domanId = domanId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
