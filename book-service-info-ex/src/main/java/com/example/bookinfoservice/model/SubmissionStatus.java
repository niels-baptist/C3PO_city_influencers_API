package com.example.bookinfoservice.model;

import javax.persistence.*;

@Entity
@Table(name="submission_status", schema = "nocaps")
public class SubmissionStatus {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    @Column(name = "\"status_id\"")
    private int statusId;
    @Column(name = "\"name\"")
    private String name;

    public SubmissionStatus(int statusId, String name) {
        this.statusId = statusId;
        this.name = name;
    }

    public SubmissionStatus() {
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}