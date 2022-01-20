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
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="role_id", nullable=true)
    private Employee_role employee_role;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=true)
    private User user;

    public Employee() {
    }

    public Employee(int employeeId,User user, Employee_role roleId) {
        this.employeeId = employeeId;
        this.user = user;
        this.employee_role = employee_role;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Employee_role getRoleId() {
        return employee_role;
    }

    public void setRoleId(Employee_role roleId) {
        this.employee_role = roleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
