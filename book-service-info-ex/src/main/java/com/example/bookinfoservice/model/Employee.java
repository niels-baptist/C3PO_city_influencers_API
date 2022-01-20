package com.example.bookinfoservice.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name="employee", schema = "nocaps")
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "\"employee_id\"")
    private int employeeId;
    @Column(name = "\"role_id\"")
    private int roleId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=true)
    private User user;

    public Employee() {
    }

    public Employee(int employeeId,User user, int roleId) {
        this.employeeId = employeeId;
        this.user = user;
        this.roleId = roleId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
