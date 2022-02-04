package com.example.bookinfoservice.controller;
import com.example.bookinfoservice.Form.EmployeeForm;
import com.example.bookinfoservice.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.example.bookinfoservice.repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    Employee_roleRepository employee_roleRepository;
    @Autowired
    LocationRepository locationRepository;

    // // Employee CRUD

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }
    @GetMapping("/employees/{employee_id}")
    public Employee getEmployee(@PathVariable int employee_id){
        return employeeRepository.findByEmployeeId(employee_id);
    }

    @PostMapping(value = "/employees")
    @ResponseBody
    public Employee addEmployee(@RequestBody Employee employee){
        // automaticaly saves the user as well
        User user = employee.getUser();
        employee.setUser(userRepository.save(new User(user.getLocation(), user.getEmail(),user.getPassword(), user.getFirstname(), user.getLastname(), user.getUserName(), user.getBirthdate())));
        return employeeRepository.save(new Employee(employee.getEmployee_role(),employee.getUser()));
    }
    @PostMapping(value = "/employees/employeeForm")
    @ResponseBody
    public Employee addEmployeeForm(@RequestBody EmployeeForm employeeForm) {
        Employee employee = employeeForm.createEmployee(locationRepository.findByLocationId(employeeForm.getLocationId()),employee_roleRepository.findByRoleId(employeeForm.getRoleId()));
        User user = employee.getUser();
        employee.setUser(userRepository.save(new User(user.getLocation(), user.getEmail(),user.getPassword(), user.getFirstname(), user.getLastname(), user.getUserName(), user.getBirthdate())));
        return employeeRepository.save(new Employee(employee.getEmployee_role(),employee.getUser()));
    }

    @PutMapping(value = "/employees/employeeForm")
    @ResponseBody
    public Employee updateEmployeeForm(@RequestBody EmployeeForm employeeForm) {
        Employee employee = employeeForm.getEmployee(locationRepository.findByLocationId(employeeForm.getLocationId()),employee_roleRepository.findByRoleId(employeeForm.getRoleId()));
        User user = employee.getUser();
        employee.setUser(userRepository.save(user));
        return employeeRepository.save(employee);
    }

    @PutMapping(value = "/employees", consumes =MediaType.APPLICATION_JSON_VALUE ,
            headers = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody

    public Employee updateEmployee(@RequestBody Employee employee){
        // automaticaly saves the user as well
        employee.setUser(userRepository.save(employee.getUser()));
        return employeeRepository.save(employee);
    }

    @DeleteMapping(value = "/employees/{employee_id}")
    public void deleteEmployee(@PathVariable int employee_id){
        employeeRepository.deleteById(employee_id);
    }
}
