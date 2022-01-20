package com.example.bookinfoservice.model;
import javax.persistence.*;

@Entity
@Table(name="employee_role", schema = "nocaps")
public class Employee_role {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "\"role_id\"")
    private int roleId;
    @Column(name = "\"name\"")
    private String name;

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
}
