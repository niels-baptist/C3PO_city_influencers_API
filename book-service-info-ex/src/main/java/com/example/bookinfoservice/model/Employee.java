package com.example.bookinfoservice.model;

import javax.persistence.*;

@Entity
@Table(name="employee", schema = "nocaps")
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "\"employee_id\"")
    private int employeeId;
    @Column(name = "\"user_id\"")
    private int userId;
    @Column(name = "\"role_id\"")
    private int roleId;

    public Employee() {
    }

    public Employee(int employeeId, int userId, int roleId) {
        this.employeeId = employeeId;
        this.userId = userId;
        this.roleId = roleId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
