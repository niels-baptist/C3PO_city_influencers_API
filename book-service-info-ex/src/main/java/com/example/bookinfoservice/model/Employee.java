package com.example.bookinfoservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="employee", schema = "nocaps")
@JsonIgnoreProperties(value = {"campaigns","hibernateLazyInitializer"}, allowSetters = true)
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "\"employee_id\"")
    private int employeeId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="role_id", nullable=true)
    private Employee_role employee_role;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=true)
    private User user;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Campaign> campaigns;

    public Employee() {
    }

    public Employee(int employeeId, Employee_role employee_role, User user, List<Campaign> campaigns) {
        this.employeeId = employeeId;
        this.employee_role = employee_role;
        this.user = user;
        this.campaigns = campaigns;
    }

    public Employee(Employee_role employee_role, User user) {
        this.employee_role = employee_role;
        this.user = user;
    }

    public Employee_role getEmployee_role() {
        return employee_role;
    }

    public void setEmployee_role(Employee_role employee_role) {
        this.employee_role = employee_role;
    }

    public List<Campaign> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<Campaign> campaigns) {
        this.campaigns = campaigns;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
