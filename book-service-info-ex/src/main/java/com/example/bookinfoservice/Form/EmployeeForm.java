package com.example.bookinfoservice.Form;

import com.example.bookinfoservice.model.Employee;
import com.example.bookinfoservice.model.Employee_role;
import com.example.bookinfoservice.model.Location;
import com.example.bookinfoservice.model.User;

import java.util.Date;

public class EmployeeForm {
    private int employeeId;
    private int userId;
    private int locationId;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private String userName;
    private Date birthdate;
    private int roleId;


    public EmployeeForm(int employeeId, int userId, int locationId, String email, String password, String firstname, String lastname, String userName, Date birthdate, int roleId) {
        this.employeeId = employeeId;
        this.userId = userId;
        this.locationId = locationId;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.userName = userName;
        this.birthdate = birthdate;
        this.roleId = roleId;
    }

    public Employee createEmployee(Location location, Employee_role employeeRole){
        User user = new User(location,  email,  password,  firstname,  lastname,  userName,  birthdate);
        return new Employee(employeeRole,user);
    }

    public Employee getEmployee(Location location, Employee_role employeeRole){
        User user = new User(userId, location,  email,  password,  firstname,  lastname,  userName,  birthdate);
        return new Employee(employeeId, employeeRole,user);
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



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
