package com.example.bookinfoservice.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name="employee_role", schema = "nocaps")
@JsonIgnoreProperties(value = {"employee","hibernateLazyInitializer"}, allowSetters = true)
public class Employee_role {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "\"role_id\"")
    private int roleId;
    @Column(name = "\"name\"")
    private String name;

    @OneToOne(cascade=ALL,mappedBy = "employee_role")
    private Employee employee;
    public Employee_role(){}
    public Employee_role(int role_id, String name){
        this.roleId = role_id;
        this.name = name;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int role_id) {
        this.roleId = role_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
